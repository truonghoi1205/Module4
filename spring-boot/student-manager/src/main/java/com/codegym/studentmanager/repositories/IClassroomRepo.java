package com.codegym.studentmanager.repositories;

import com.codegym.studentmanager.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassroomRepo extends JpaRepository<Classroom,Long> {
}
