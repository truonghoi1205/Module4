package com.codegym.studentmanager.services;

import com.codegym.studentmanager.models.Classroom;
import com.codegym.studentmanager.repositories.IClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService implements IClassroomService{

    @Autowired
    private IClassroomRepo classroomRepo;

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepo.findAll();
    }
}
