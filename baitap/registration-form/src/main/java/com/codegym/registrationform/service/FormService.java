package com.codegym.registrationform.service;


import com.codegym.registrationform.model.Form;
import com.codegym.registrationform.repository.IFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService{

    @Autowired
    private IFormRepo formRepo;
    @Override
    public void save(Form form) {
        formRepo.save(form);
    }
}
