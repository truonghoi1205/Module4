package com.codegym.library.controller.admin;


import com.codegym.library.dto.BookDto;
import com.codegym.library.model.Book;
import com.codegym.library.service.book.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String listBook(Model model,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Page<Book> books = bookService.findAllByName(name, PageRequest.of(page, 5, sort));
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "book/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute BookDto bookDto,
                       BindingResult result,
                       Model model,
                       RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("bookDto", bookDto);
            return "book/create";
        }
        Book book = new Book();
        book.setCode(bookService.generateUniqueBorrowCode());
        BeanUtils.copyProperties(bookDto, book);
        bookService.save(book);
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        return "redirect:/admin/book";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         @ModelAttribute Book book,
                         RedirectAttributes redirect) {
        bookService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/admin/book";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Book book = bookService.findById(id);
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book,bookDto);
        if (book.equals(null)) {
            return "redirect:/admin/book";
        }
        model.addAttribute("bookDto", bookDto);
        return "book/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute BookDto bookDto,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("bookDto", bookDto);
            return "book/update";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        book.setCode(book.getCode());
        bookService.save(book);
        redirect.addFlashAttribute("noti", "Cập nhật thành công!");
        return "redirect:/admin/book";
    }
}
