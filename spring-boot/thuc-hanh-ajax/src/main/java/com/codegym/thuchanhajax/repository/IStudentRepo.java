package com.codegym.thuchanhajax.repository;

import com.codegym.thuchanhajax.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long>, PagingAndSortingRepository<Student,Long> {
}
