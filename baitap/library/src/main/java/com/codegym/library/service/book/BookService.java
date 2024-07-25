package com.codegym.library.service.book;

import com.codegym.library.model.Book;
import com.codegym.library.repository.book.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepo bookRepo;

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Book> findAllByName(String name, Pageable pageable) {
        return bookRepo.findAllByNameContaining(name, pageable);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public String generateUniqueBorrowCode() {
        String code;
        do {
            code = String.format("B%04d", new Random().nextInt(99999));
        } while (bookRepo.findBookByCode(code) != null);
        return code;
    }
}
