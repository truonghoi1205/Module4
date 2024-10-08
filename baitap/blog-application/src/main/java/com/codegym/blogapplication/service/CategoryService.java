package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.model.Category;
import com.codegym.blogapplication.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> findAll(String name, Pageable pageable) {
        return categoryRepo.findAllByNameContaining(name,pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
       return categoryRepo.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepo.findById(id);
    }


}
