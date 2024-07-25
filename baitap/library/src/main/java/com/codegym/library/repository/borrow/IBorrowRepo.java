package com.codegym.library.repository.borrow;

import com.codegym.library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepo extends JpaRepository<Borrow,Long> {
    Borrow findBorrowByCode(String borrowCode);
}
