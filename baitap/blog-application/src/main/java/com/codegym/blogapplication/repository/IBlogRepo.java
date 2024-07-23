package com.codegym.blogapplication.repository;

import com.codegym.blogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blog, Long> {

    @Query(nativeQuery = true, value = "select * from blog as b where b.title like :title")

    Page<Blog> findAllByTitle(@Param("title") String title, Pageable pageable);
}
