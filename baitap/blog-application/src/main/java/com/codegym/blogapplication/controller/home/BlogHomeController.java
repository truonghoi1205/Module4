package com.codegym.blogapplication.controller.home;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.model.Category;
import com.codegym.blogapplication.service.IBlogService;
import com.codegym.blogapplication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogHomeController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private Iterable<Category> showAllCategory() {
        Iterable<Category> categories = categoryService.findAll();
        return categories;
    }

    @GetMapping("")
    public String home(Model model,
                       @RequestParam(defaultValue = "") String title,
                       @RequestParam(defaultValue = "0") int category_id,
                       @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("title").descending();
        Page<Blog> blogList;
        if(category_id == 0) {
            blogList = blogService.findAllByTitle(title, PageRequest.of(page, 5, sort));
        } else {
            blogList = blogService.findAllBlogByCategoryId(category_id, PageRequest.of(page, 5, sort));
        }
        model.addAttribute("blogList", blogList);
        model.addAttribute("category_id", category_id);
        model.addAttribute("title", title);
        return "home";
    }

    @GetMapping("{id}/content")
    public String showContent(Model model,
                              @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog.equals(null)) {
            return "redirect:/blog";
        }
        model.addAttribute("blog", blog);
        return "/content";
    }
}
