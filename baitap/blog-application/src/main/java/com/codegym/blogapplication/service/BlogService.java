package com.codegym.blogapplication.service;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id).orElse(null);
    }



    @Override
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return blogRepo.findAllByTitleContaining(title, pageable);
    }

    @Override
    public void deleteById(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public Page<Blog> findAllBlogByCategoryId(int categoryId, Pageable pageable) {
        return blogRepo.findAllByCategory_Id(categoryId,pageable);
    }



}
