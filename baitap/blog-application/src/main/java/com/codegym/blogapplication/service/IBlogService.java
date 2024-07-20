package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;

public interface IBlogService {
    Iterable<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Long id);

    void update(Long id);
}
