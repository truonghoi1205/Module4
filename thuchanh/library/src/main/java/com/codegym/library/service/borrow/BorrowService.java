package com.codegym.library.service.borrow;

import com.codegym.library.model.Book;
import com.codegym.library.model.Borrow;
import com.codegym.library.repository.borrow.IBorrowRepo;
import com.codegym.library.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowService implements IBorrowService{

    @Autowired
    private IBorrowRepo borrowRepo;
    @Autowired
    private IBookService bookService;

    @Override
    public Iterable<Borrow> findAll() {
        return borrowRepo.findAll();
    }

    @Override
    public void save(Borrow borrow) throws Exception{
        Book book = borrow.getBook();
        if (book.getQuantity() == 0) {
            throw new RuntimeException("Book out of stock");
        }
        if(book.getQuantity() > 0) {
            borrowRepo.save(borrow);
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
        } else {
           throw new Exception();
        }
    }

    @Override
    public Borrow findById(Long id) {
        return borrowRepo.findById(id).orElse(null);
    }

    @Override
    public void returnBorrow(Borrow borrow) {
        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);

        borrow.setStatus(true);
        borrowRepo.save(borrow);
    }
    @Override
    public String generateUniqueBorrowCode() {
        String code;
        do {
            code = String.format("%05d", new Random().nextInt(99999));
        } while (borrowRepo.findBorrowByCode(code) != null);
        return code;
    }

}
