package com.codegym.btltm4.controler;

import com.codegym.btltm4.model.Pig;
import com.codegym.btltm4.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pig")
public class PigController {
    @Autowired
    private PigService pigService;

    @GetMapping("/list")
    public String listPig(Model model) {
        model.addAttribute("pigs", pigService.getAllPig());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editPig(@PathVariable Long id, Model model) {
        Pig pig = pigService.getPigById(id);
        model.addAttribute("pig", pig);
        return "edit";
    }

    @PostMapping("/save")
    public String saveHeo(@ModelAttribute Pig pig) {
        pigService.savePig(pig);
        return "redirect:/pig/list";
    }

    @PostMapping("/delete/{id}")
    public String deletePig(@PathVariable Long id) {
        pigService.deletePig(id);
        return "redirect:/pig/list";
    }
}
