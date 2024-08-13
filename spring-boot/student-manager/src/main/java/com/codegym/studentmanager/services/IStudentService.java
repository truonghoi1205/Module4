package com.codegym.studentmanager.services;

import com.codegym.studentmanager.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {

    void save(Student student);

    Student findById(Long id);

    void deleteById(Long id);

    Page<Student> findStudentByName(String keyword, Pageable pageable);
}
