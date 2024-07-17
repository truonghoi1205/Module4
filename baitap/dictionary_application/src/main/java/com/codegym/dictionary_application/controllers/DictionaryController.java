package com.codegym.dictionary_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("Hello","Xin chào");
        dictionary.put("GoodBye","tạm biệt");
    }
    @GetMapping("")
    public String showForm() {
        return "form";
    }

    @PostMapping("/a")
    public String result(@RequestParam ("keyword") String keyword, Model model) {
        String result = dictionary.get(keyword);
        if(result != null) {
            model.addAttribute("result",result);
        } else {
            model.addAttribute("message","k có từ này");
        }
        return "form";
    }
}
