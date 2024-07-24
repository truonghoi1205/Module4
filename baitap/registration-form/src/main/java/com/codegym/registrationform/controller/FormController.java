package com.codegym.registrationform.controller;

import com.codegym.registrationform.DTO.FormDto;
import com.codegym.registrationform.model.Form;
import com.codegym.registrationform.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    private IFormService formService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("formDto", new FormDto());
        return "index";
    }

    @PostMapping("")
    public String register(@Validated @ModelAttribute FormDto formDto,
                           BindingResult result,
                           Model model) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("formDto", formDto);
            return "index";
        }
        Form form = new Form();
        BeanUtils.copyProperties(formDto, form);
        formService.save(form);
        return "result";
    }
}
