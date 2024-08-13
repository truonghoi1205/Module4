package com.codegym.thimodul4.controllers;

import com.codegym.thimodul4.dto.OrderDTO;
import com.codegym.thimodul4.models.Orders;
import com.codegym.thimodul4.models.Product;
import com.codegym.thimodul4.models.ProductType;
import com.codegym.thimodul4.services.IOrderService;
import com.codegym.thimodul4.services.IProductService;
import com.codegym.thimodul4.services.IProductTypeService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Controller
public class OrderController {

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("productTypes")
    private Iterable<ProductType> showAllCategory() {
        Iterable<ProductType> productTypes = productTypeService.findAll();
        return productTypes;
    }

    @ModelAttribute("products")
    private Iterable<Product> showAllProduct() {
        Iterable<Product> products = productService.findAll();
        return products;
    }

    @GetMapping("/orders")
    public String listOrders(Model model,
                             @RequestParam(defaultValue = "0") int page) {

        Page<Orders> orders = orderService.getAllOrders(PageRequest.of(page, 2));
        model.addAttribute("orders", orders);
        return "index";
    }

    @GetMapping("/orders/{id}/update")
    public String showFormEdit(Model model,
                               @PathVariable Long id) {
        Orders orders = orderService.findById(id);
        model.addAttribute("orders", orders);

        return "edit";
    }

    @PostMapping("/orders/{id}/update")
    private String update(
            @PathVariable Long id,
            @Validated @ModelAttribute OrderDTO orderDTO,
            BindingResult bindingResult,
            RedirectAttributes redirect,
            Model model) {
        model.addAttribute("isSubmitted", true);
        if (bindingResult.hasErrors()) {
            model.addAttribute("orders", orderDTO);
            return "edit";
        }
        Orders orders = orderService.findById(id);
        orders.setQuantity(orderDTO.getQuantity());
        Product product = productService.findById(orderDTO.getProduct() );
        orders.setProduct(product);
        orderService.save(orders);
        return "redirect:/orders";
    }

}
