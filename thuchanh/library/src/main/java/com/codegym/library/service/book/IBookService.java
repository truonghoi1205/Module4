package com.codegym.library.service.book;

import com.codegym.library.dto.BookDto;
import com.codegym.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    void save(Book book);

    Book findById(Long id);

    Page<Book> findAllByName(String name, Pageable pageable);

    void deleteById(Long id);

    String generateUniqueBorrowCode();
}
