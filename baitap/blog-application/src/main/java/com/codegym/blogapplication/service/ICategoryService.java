package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Page<Category> findAll(String name, Pageable pageable);

    Category findById(Long id);

    Category save(Category category);

    void deleteById(Long id);

    Optional<Category> findCategoryById(Long id);

}
