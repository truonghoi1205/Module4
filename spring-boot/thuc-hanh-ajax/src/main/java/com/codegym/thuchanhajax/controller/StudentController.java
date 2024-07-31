package com.codegym.thuchanhajax.controller;

import com.codegym.thuchanhajax.model.Student;
import com.codegym.thuchanhajax.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> findAllStudent(@RequestParam(defaultValue = "2") int page) {
        Pageable pageable = PageRequest.of(0,page);
        Page<Student> students = studentService.findAllStudent(pageable);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
    }
}
