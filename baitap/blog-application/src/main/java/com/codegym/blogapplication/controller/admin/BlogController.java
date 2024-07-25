package com.codegym.blogapplication.controller.admin;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.model.Category;
import com.codegym.blogapplication.model.DTO.BlogFormCreateDto;
import com.codegym.blogapplication.model.DTO.BlogFormUpdateDto;
import com.codegym.blogapplication.service.IBlogService;
import com.codegym.blogapplication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {
    @Value("${upload.path}")
    private String fileUpload;

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
    public String showList(Model model,
                           @RequestParam(defaultValue = "") String title,
                           @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("title").descending();
        Page<Blog> blogList = blogService.findAllByTitle(title, PageRequest.of(page, 5, sort));
        model.addAttribute("blogList", blogList);
        model.addAttribute("title", title);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
            model.addAttribute("blogFromCreateDto", new BlogFormCreateDto());
            return "blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute BlogFormCreateDto blogFromCreateDto,
                       RedirectAttributes redirect) {
        MultipartFile multipartFile = blogFromCreateDto.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            System.out.println(fileUpload + fileName);
            FileCopyUtils.copy(blogFromCreateDto.getAvatar().getBytes(), new File(fileUpload + fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Blog blog = new Blog(blogFromCreateDto.getId(), blogFromCreateDto.getTitle(), blogFromCreateDto.getContent(), blogFromCreateDto.getAuthor(), fileName, blogFromCreateDto.getCategory());
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        blogService.save(blog);
        return "redirect:/admin/blog";
    }

    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute Blog blog,
                         @PathVariable Long id,
                         RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/admin/blog";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog.equals(null)) {
            return "redirect:/admin/blog";
        }
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BlogFormUpdateDto blogFormUpdateDto,
                         RedirectAttributes redirect) {
        MultipartFile multipartFile = blogFormUpdateDto.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogFormUpdateDto.getAvatar().getBytes(), new File(fileUpload + fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Blog blog = new Blog(blogFormUpdateDto.getId(), blogFormUpdateDto.getTitle(), blogFormUpdateDto.getContent(), blogFormUpdateDto.getAuthor(), fileName, blogFormUpdateDto.getCategory());
        redirect.addFlashAttribute("noti", "Cập nhật thành công!");
        blogService.save(blog);
        return "redirect:/admin/blog";
    }


}
