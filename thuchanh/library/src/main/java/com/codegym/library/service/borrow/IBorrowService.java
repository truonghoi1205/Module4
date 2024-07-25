package com.codegym.library.service.borrow;

import com.codegym.library.model.Book;
import com.codegym.library.model.Borrow;

public interface IBorrowService {
    Iterable<Borrow> findAll();

    void save(Borrow borrow) throws Exception;

    Borrow findById(Long id);

    void returnBorrow(Borrow borrow);

    String generateUniqueBorrowCode();
}
