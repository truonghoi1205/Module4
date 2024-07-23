package com.codegym.blogapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String author;
    private String avatar;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Blog(Long id, String title, String content, String author, String avatar) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.avatar = avatar;
    }
}
