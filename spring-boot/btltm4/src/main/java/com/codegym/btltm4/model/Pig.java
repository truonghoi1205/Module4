package com.codegym.btltm4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDateTime importTime;

    @Min(10)
    private double importWeight;

    private LocalDateTime exportTime;

    private double exportWeight;

    @ManyToOne
    private Origin origin;

    private boolean sold;

}
