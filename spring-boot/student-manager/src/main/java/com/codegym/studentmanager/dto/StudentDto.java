package com.codegym.studentmanager.dto;

import com.codegym.studentmanager.models.Classroom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class StudentDto {
    private Long id;
    @NotBlank(message = "Tên bắt buộc")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Tên chưa đúng định dạng")
    private String name;
    @NotBlank(message = "Địa chỉ bắt buộc")
    @Pattern(regexp = "^[\\p{L}\\d ,.-]+$", message = "Địa chỉ chưa đúng định dạng")
    private String address;
    @NotNull(message = "Ngày sinh bắt buộc")
    private Date dob;
    private Classroom classroom;
}
