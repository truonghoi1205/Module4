package com.codegym.library.service.student;

import com.codegym.library.model.Student;

public interface IStudentService {
    Iterable<Student> findAll();
}
