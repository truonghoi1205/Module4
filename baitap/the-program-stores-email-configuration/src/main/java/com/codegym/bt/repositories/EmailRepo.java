package com.codegym.bt.repositories;

import com.codegym.bt.models.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepo implements IEmailRepo{
    private Email email = new Email("Vietnam",20,true,"Hội");

    @Override
    public Email getAll() {
        return email;
    }

    @Override
    public void update(Email email) {
        email.setLanguage(email.getLanguage());
        email.setPageSize(email.getPageSize());
        email.setSpam(email.isSpam());
        email.setSignature(email.getSignature());
    }
}
