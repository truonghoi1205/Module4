package com.codegym.library.controller.home;

import com.codegym.library.model.Book;
import com.codegym.library.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/library")
public class BookHomeController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String listBook(Model model,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Page<Book> books = bookService.findAllByName(name, PageRequest.of(page, 5, sort));
        model.addAttribute("books",books);
        return "home";
    }
}
