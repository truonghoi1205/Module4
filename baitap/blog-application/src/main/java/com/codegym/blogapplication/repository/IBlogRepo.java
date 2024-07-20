package com.codegym.blogapplication.repository;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blog, Long> {

}
