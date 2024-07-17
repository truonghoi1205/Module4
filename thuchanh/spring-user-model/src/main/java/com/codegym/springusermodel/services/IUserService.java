package com.codegym.springusermodel.services;

import com.codegym.springusermodel.models.Login;
import com.codegym.springusermodel.models.User;

public interface IUserService {
    User checkLogin(Login login);
}
