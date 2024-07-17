package com.codegym.currency_conversion_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
public class MoneyController {
    @GetMapping("")
    public String showForm() {
        return "form";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double usd,Model model) {
        double vnd = 23000 * usd;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "result";
    }
}
