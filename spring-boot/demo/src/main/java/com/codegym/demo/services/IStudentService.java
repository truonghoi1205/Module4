package com.codegym.demo.services;

import com.codegym.demo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IStudentService {

    Page<Student> findAll(Pageable pageable);
}
