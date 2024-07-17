package com.codegym.springusermodel.repositories;

import com.codegym.springusermodel.models.Login;
import com.codegym.springusermodel.models.User;

public interface IUserRepo {
    User checkLogin(Login login);
}
