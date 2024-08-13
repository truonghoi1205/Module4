package com.codegym.studentmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Date dob;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classroom classroom;
}
