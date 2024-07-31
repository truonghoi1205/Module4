package com.codegym.thuchanhajax.controller;

import com.codegym.thuchanhajax.model.Classroom;
import com.codegym.thuchanhajax.model.Student;
import com.codegym.thuchanhajax.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    private IClassroomService classroomService;


    @GetMapping("")
    public ResponseEntity<?> findAllClassroom(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Classroom> classrooms = classroomService.findAllClassroom(pageable);
        if (classrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }
}
