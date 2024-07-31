package com.codegym.thuchanhajax.service.student;

import com.codegym.thuchanhajax.model.Student;
import com.codegym.thuchanhajax.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public Page<Student> findAllStudent(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }
}
