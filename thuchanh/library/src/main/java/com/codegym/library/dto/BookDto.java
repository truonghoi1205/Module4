package com.codegym.library.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotEmpty(message = "Tên sách không được để trống")
    private String name;
    @NotEmpty(message = "Tên tác giả không được để trống")
    private String author;
    @NotEmpty(message = "Nội dung không được để trống")
    private String description;
    @Min(value = 0, message = "số lượng lớn hơn hoặc bằng 0")
    @NotNull(message = "Số lượng không được để trống")
    private Integer quantity;
}
