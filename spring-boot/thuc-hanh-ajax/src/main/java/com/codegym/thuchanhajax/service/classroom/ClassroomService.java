package com.codegym.thuchanhajax.service.classroom;

import com.codegym.thuchanhajax.model.Classroom;
import com.codegym.thuchanhajax.model.Student;
import com.codegym.thuchanhajax.repository.IClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    private IClassroomRepo classroomRepo;

    @Override
    public Page<Classroom> findAllClassroom(Pageable pageable) {
        return classroomRepo.findAll(pageable);
    }
}
