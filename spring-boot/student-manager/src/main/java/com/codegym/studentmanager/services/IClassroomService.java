package com.codegym.studentmanager.services;

import com.codegym.studentmanager.models.Classroom;

public interface IClassroomService {
    Iterable<Classroom> findAll();
}
