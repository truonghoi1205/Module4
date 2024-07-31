package com.codegym.thuchanhajax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private String address;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
