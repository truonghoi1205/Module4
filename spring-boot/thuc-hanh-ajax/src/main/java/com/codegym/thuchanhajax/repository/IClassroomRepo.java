package com.codegym.thuchanhajax.repository;

import com.codegym.thuchanhajax.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepo extends JpaRepository<Classroom,Long>, PagingAndSortingRepository<Classroom,Long> {
}
