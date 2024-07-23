package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Category;
import com.codegym.blogapplication.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }
}
