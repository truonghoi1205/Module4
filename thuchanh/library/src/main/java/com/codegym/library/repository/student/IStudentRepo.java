package com.codegym.library.repository.student;

import com.codegym.library.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
}
