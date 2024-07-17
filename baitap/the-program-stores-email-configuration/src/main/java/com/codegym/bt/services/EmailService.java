package com.codegym.bt.services;

import com.codegym.bt.models.Email;
import com.codegym.bt.repositories.IEmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepo emailRepo;

    @Override
    public Email getAll() {
        return emailRepo.getAll();
    }

    @Override
    public void update(Email email) {
        emailRepo.update(email);
    }
}
