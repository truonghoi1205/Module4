package com.codegym.customer_marnager.controllers;

import com.codegym.customer_marnager.models.Customer;
import com.codegym.customer_marnager.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/{id}")
    public String showInformation(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "info";
    }

    @PostMapping
    public String updateCustomer(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 RedirectAttributes redirect) {
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        redirect.addFlashAttribute("message","Cập nhật thành công");
        return "redirect:/customers";
    }
}
