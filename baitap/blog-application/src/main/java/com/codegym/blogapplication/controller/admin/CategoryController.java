package com.codegym.blogapplication.controller.admin;

import com.codegym.blogapplication.model.Category;
import com.codegym.blogapplication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showListCategory(Model model,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Page<Category> categories = categoryService.findAll(name, PageRequest.of(page, 5, sort));
        model.addAttribute("categories", categories);
        model.addAttribute("name", name);
        return "category/list";
    }


    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Category category,
                       RedirectAttributes redirect) {
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        categoryService.save(category);
        return "redirect:/admin/categories";
    }


    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category.equals(null)) {
            return "redirect:/admin/categories";
        }
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category,
                         RedirectAttributes redirect) {
        category = new Category();
        redirect.addFlashAttribute("noti", "Cập nhật thành công!");
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute Category category,
                         @PathVariable Long id,
                         RedirectAttributes redirect) {
        categoryService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/admin/categories";
    }
}
