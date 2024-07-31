package com.codegym.blogapplication.controller.admin;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<?> findAllBlog(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogs = blogService.findAllBlog(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Blog>> findAllBlogByCategory(@RequestParam Integer categoryId) {
        List<Blog> blogs = blogService.findAllBlogByCategory(categoryId);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findBlogById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByTitle(@RequestParam(defaultValue = "") String keyword,@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Blog> blogs = blogService.findAllByTitle(keyword,pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
