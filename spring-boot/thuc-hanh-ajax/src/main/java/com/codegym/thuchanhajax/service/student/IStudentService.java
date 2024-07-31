package com.codegym.thuchanhajax.service.student;

import com.codegym.thuchanhajax.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStudentService {
    Page<Student> findAllStudent(Pageable pageable);

    void save(Student student);

    void remove(Long id);

    Optional<Student> findById(Long id);
}
