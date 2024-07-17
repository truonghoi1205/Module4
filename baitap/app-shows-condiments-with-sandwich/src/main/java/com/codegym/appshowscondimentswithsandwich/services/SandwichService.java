package com.codegym.appshowscondimentswithsandwich.services;

import com.codegym.appshowscondimentswithsandwich.repositories.ISandwichRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    private ISandwichRepo sandwichRepo;

    @Override
    public String[] getAllCondiments() {
        return sandwichRepo.getAllCondiments();
    }
}
