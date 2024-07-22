package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Long id);

    void update(Long id);
}
