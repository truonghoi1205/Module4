package com.codegym.springusermodel.repositories;

import com.codegym.springusermodel.models.Login;
import com.codegym.springusermodel.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo implements IUserRepo{
    private static final List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("a", "1", "John", "john@codegym.vn", 18));
        users.add(new User("b", "1", "Bill", "bill@codegym.vn", 20));
        users.add(new User("c", "1", "Mike", "mike@codegym.vn", 22));
    }
    public User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
