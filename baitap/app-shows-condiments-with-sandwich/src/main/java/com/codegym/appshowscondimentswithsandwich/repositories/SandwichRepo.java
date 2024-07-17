package com.codegym.appshowscondimentswithsandwich.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepo implements ISandwichRepo{
    @Override
    public String[] getAllCondiments() {
        return new String[] {"Lettuce", "Tomato", "Mustard", "Sprouts"};
    }
}
