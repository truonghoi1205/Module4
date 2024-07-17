package com.codegym.personalcalculator.controllers;

import com.codegym.personalcalculator.services.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/home")
    public String calculate(Model model,
                            @RequestParam(defaultValue = "0") String numStr1,
                            @RequestParam(defaultValue = "0") String numStr2,
                            @RequestParam String operation) {

        try {
            double num1 = Double.parseDouble(numStr1);
            double num2 = Double.parseDouble(numStr2);
            double result = calculatorService.calculate(num1, num2, operation);
            model.addAttribute("result", result);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}
