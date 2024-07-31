package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    Page<Blog> findAllByTitle(String title, Pageable pageable);

    void deleteById(Long id);

    Page<Blog> findAllBlogByCategoryId(int categoryId, Pageable pageable);

    Page<Blog> findAllBlog(Pageable pageable);

    Optional<Blog> findBlogById(Long id);

    List<Blog> findAllBlogByCategory(int categoryId);

}
