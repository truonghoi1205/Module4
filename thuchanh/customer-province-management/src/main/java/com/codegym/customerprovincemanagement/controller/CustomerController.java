package com.codegym.customerprovincemanagement.controller;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.service.customer.ICustomerService;
import com.codegym.customerprovincemanagement.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;


    @GetMapping("")
    public String showAll(Model model) {
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }
}
