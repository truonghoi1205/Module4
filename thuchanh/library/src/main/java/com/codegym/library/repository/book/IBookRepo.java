package com.codegym.library.repository.book;

import com.codegym.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameContaining(String name, Pageable pageable);

    Book findBookByCode(String code);
}
