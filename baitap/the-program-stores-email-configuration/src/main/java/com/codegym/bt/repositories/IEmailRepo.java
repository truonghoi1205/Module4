package com.codegym.bt.repositories;

import com.codegym.bt.models.Email;

public interface IEmailRepo {
    Email getAll();

    void update(Email email);
}
