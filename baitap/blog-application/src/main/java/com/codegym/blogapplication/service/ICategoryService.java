package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();


}
