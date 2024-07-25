package com.codegym.library.service.student;

import com.codegym.library.model.Student;
import com.codegym.library.repository.student.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }
}
