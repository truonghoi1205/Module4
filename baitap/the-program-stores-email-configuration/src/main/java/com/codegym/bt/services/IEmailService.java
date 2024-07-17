package com.codegym.bt.services;

import com.codegym.bt.models.Email;

public interface IEmailService {
    Email getAll();

    void update(Email email);
}
