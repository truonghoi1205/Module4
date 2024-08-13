package com.codegym.studentmanager.controllers;

import com.codegym.studentmanager.dto.StudentDto;
import com.codegym.studentmanager.models.Classroom;
import com.codegym.studentmanager.models.Student;
import com.codegym.studentmanager.services.IClassroomService;
import com.codegym.studentmanager.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/list")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;


    @ModelAttribute("classrooms")
    private Iterable<Classroom> showAllClassroom() {
        Iterable<Classroom> classrooms = classroomService.findAll();
        return classrooms;
    }

    @GetMapping("")
    public String showAllStudent(Model model,
                                 @RequestParam(defaultValue = "") String name,
                                 @RequestParam(defaultValue = "0") int page) {
        Page<Student> students = studentService.findStudentByName(name, PageRequest.of(page, 5));
        model.addAttribute("students", students);
        model.addAttribute("name",name);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute StudentDto studentDto,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        return "redirect:/list";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(@PathVariable Long id,
                                 Model model) {
        Student student = studentService.findById(id);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        if (student.equals(null)) {
            return "redirect:/list";
        }
        model.addAttribute("studentDto", studentDto);
        return "update";
    }

    @PostMapping("/update")
    public String updateStudent(@Validated @ModelAttribute StudentDto studentDto,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "update";
        }
        redirect.addFlashAttribute("noti", "Cập nhật thành công!");
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return "redirect:/list";
    }

    @PostMapping("{id}/delete")
    public String deleteStudent(@PathVariable Long id,
                                @ModelAttribute Student student,
                                RedirectAttributes redirect) {
        studentService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/list";
    }


}
