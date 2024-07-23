package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    Page<Blog> findAllByTitle(String title, Pageable pageable);

    void deleteById(Long id);

    Page<Blog> findAllBlogByCategoryId(int categoryId, Pageable pageable);
}
