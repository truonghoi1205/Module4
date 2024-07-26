package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
        public String addToCart(@PathVariable Long id,
                @ModelAttribute Cart cart,
                @RequestParam(value = "action",defaultValue = "list") String action) {
            Optional<Product> productOptional = productService.findById(id);
            if (!productOptional.isPresent()) {
                return "/error_404";
            }
            if (action.equals("show")) {
                cart.addProduct(productOptional.get());
                return "redirect:/shopping-cart";
            }
            cart.addProduct(productOptional.get());
            return "redirect:/shop";
    }

    @GetMapping("/minus/{id}")
    public String minusToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam(value = "action",defaultValue = "list") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.minusProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("{id}/detail")
    public String showContent(Model model,
                              @PathVariable Long id) {
        Product product = productService.findProductById(id);
        if (product.equals(null)) {
            return "redirect:/shop";
        }
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.removeProduct(productOptional.get());
        }
        return "redirect:/shopping-cart";
    }
}
