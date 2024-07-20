package com.codegym.demo.controllers;

import com.codegym.demo.models.Student;
import com.codegym.demo.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 10) Pageable pageable) {
        Page<Student> students = studentService.findAll(pageable);
        model.addAttribute("students",students);
        return "/list";
    }
}
