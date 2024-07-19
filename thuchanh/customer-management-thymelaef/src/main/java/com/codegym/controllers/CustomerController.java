package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.ICustomerService;
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
    public String index(Model model) {
        List<Customer> customerList = customerService.showAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,
                         Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer,
                         RedirectAttributes redirect) {
        customerService.delete(customer.getId());
        redirect.addFlashAttribute("success", "Xóa thành công!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/update")
    public String update (@PathVariable int id,
                          Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer,
                         RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Cập nhật thành công!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,
                       Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/view";
    }
}
