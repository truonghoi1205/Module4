package com.codegym.appshowscondimentswithsandwich.controllers;

import com.codegym.appshowscondimentswithsandwich.services.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichService sandwichService;

    @GetMapping("/sandwich")
    public String showForm(Model model) {
        String[] condiments = sandwichService.getAllCondiments();
        model.addAttribute("condiments", condiments);
        return "sandwichForm";
    }

    @PostMapping("/save")
    public String save(@RequestParam(defaultValue = "") String[] condiments, Model model, RedirectAttributes redirect) {
        if (condiments.length > 0) {
            model.addAttribute("selectedCondiments", condiments);
            return "list";
        } else {
            redirect.addFlashAttribute("message","vui lòng chọn gia vị");
            return "redirect:/sandwich";
        }
    }
}
