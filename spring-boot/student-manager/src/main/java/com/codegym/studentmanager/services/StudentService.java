package com.codegym.studentmanager.services;

import com.codegym.studentmanager.models.Student;
import com.codegym.studentmanager.repositories.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepo studentRepo;


    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Page<Student> findStudentByName(String keyword, Pageable pageable) {
        return studentRepo.findStudentByNameContaining(keyword,pageable);
    }
}
