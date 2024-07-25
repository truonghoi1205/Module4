package com.codegym.library.controller.admin;

import com.codegym.library.model.Book;
import com.codegym.library.model.Borrow;
import com.codegym.library.model.Student;
import com.codegym.library.service.book.IBookService;
import com.codegym.library.service.borrow.IBorrowService;
import com.codegym.library.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/borrow")
public class BorrowController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IStudentService studentService;


    @GetMapping("")
    public String showListBorrow(Model model) {
        Iterable<Borrow> borrows = borrowService.findAll();
        model.addAttribute("borrows", borrows);
        return "borrow/list";
    }

    @GetMapping("{book_id}/create")
    public String formCreate(@PathVariable Long book_id,
                             Model model) {
        Book book = bookService.findById(book_id);
        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setCode(borrowService.generateUniqueBorrowCode());
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("borrow", borrow);
        model.addAttribute("students", students);
        return "borrow/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Borrow borrow,
                       RedirectAttributes redirect) {
        try {
            borrowService.save(borrow);
            redirect.addFlashAttribute("noti", "Thêm mới thành công!!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Số lượng không đủ!!");
        }
        return "redirect:/library";
    }

    @GetMapping("/{id}/return")
    public String delete(@PathVariable Long id) {
        Borrow borrow = borrowService.findById(id);
        ;
        borrowService.returnBorrow(borrow);
        return "redirect:/admin/borrow";
    }

}
