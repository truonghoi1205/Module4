package com.codegym.studentmanager.repositories;

import com.codegym.studentmanager.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Long> {
    Page<Student> findStudentByNameContaining(String keyword, Pageable pageable);
}
