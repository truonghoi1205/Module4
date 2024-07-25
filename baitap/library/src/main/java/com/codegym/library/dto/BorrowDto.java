package com.codegym.library.dto;

import com.codegym.library.model.Book;
import com.codegym.library.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date borrow_day;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date return_day;

    private Student student;
    private Book book;
}
