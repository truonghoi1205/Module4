package com.codegym.bt.controllers;

import com.codegym.bt.models.Email;
import com.codegym.bt.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email-config")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping
    public String index(Model model) {
        Email email = emailService.getAll();
        model.addAttribute("email", email);
        return "index";
    }


    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        Email email = emailService.getAll();
        String[] languages = new String[] {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] sizes = new int[] {5, 10, 15, 25, 50, 100};
        model.addAttribute("email", email);
        model.addAttribute("languages", languages);
        model.addAttribute("sizes", sizes);
        return "update";
    }

    @PostMapping("/update")
    public String updateMailSettings(@ModelAttribute("email") Email email) {
        emailService.update(email);
        return "redirect:/email-config";
    }
}
