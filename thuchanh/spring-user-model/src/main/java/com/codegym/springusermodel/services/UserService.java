package com.codegym.springusermodel.services;

import com.codegym.springusermodel.models.Login;
import com.codegym.springusermodel.models.User;
import com.codegym.springusermodel.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo userRepo;

    @Override
    public User checkLogin(Login login) {
        return userRepo.checkLogin(login);
    }
}
