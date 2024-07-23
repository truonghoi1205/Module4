package com.codegym.blogapplication.model.DTO;

import com.codegym.blogapplication.model.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BlogFormCreateDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private MultipartFile avatar;
    private Category category;
}
