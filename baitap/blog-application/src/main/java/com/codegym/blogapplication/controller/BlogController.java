package com.codegym.blogapplication.controller;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.model.DTO.BlogFormCreateDto;
import com.codegym.blogapplication.model.DTO.BlogFormUpdateDto;
import com.codegym.blogapplication.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Value("${upload.path}")
    private String fileUpload;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page) {
        Page<Blog> blogList = blogService.findAll(PageRequest.of(page,5));
        model.addAttribute("blogList", blogList);
        return "home";
    }

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page) {
        Page<Blog> blogList = blogService.findAll(PageRequest.of(page,5));
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blogFromCreateDto", new BlogFormCreateDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute BlogFormCreateDto blogFromCreateDto,
                       RedirectAttributes redirect) {
        MultipartFile multipartFile = blogFromCreateDto.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            System.out.println( fileUpload + fileName);
            FileCopyUtils.copy(blogFromCreateDto.getAvatar().getBytes(), new File(fileUpload + fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Blog blog = new Blog(blogFromCreateDto.getId(), blogFromCreateDto.getTitle(), blogFromCreateDto.getContent(), blogFromCreateDto.getAuthor(), fileName);
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("{id}/content")
    public String showContent(Model model,
                              @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if(blog.equals(null)) {
            return "redirect:/blog";
        }
        model.addAttribute("blog",blog);
        return "content";
    }

    @GetMapping("{id}/delete")
    public String showFormDelete(Model model,
                                 @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if(blog.equals(null)) {
            return "redirect:/blog/list";
        }
        model.addAttribute("blog",blog);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog,
                         RedirectAttributes redirect) {
        blogService.delete(blog.getId());
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/blog/list";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if(blog.equals(null)) {
            return "redirect:/blog/list";
        }
        model.addAttribute("blog",blog);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BlogFormUpdateDto blogFormUpdateDto,
                       RedirectAttributes redirect) {
        MultipartFile multipartFile = blogFormUpdateDto.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            System.out.println( fileUpload + fileName);
            FileCopyUtils.copy(blogFormUpdateDto.getAvatar().getBytes(), new File(fileUpload + fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Blog blog = new Blog(blogFormUpdateDto.getId(), blogFormUpdateDto.getTitle(), blogFormUpdateDto.getContent(), blogFormUpdateDto.getAuthor(), fileName);
        redirect.addFlashAttribute("noti", "Cập nhật thành công!");
        blogService.save(blog);
        return "redirect:/blog/list";
    }

}
