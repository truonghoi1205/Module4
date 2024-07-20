package com.codegym.demo.services;



import com.codegym.demo.models.Student;
import com.codegym.demo.repositories.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }
}
