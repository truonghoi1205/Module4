package com.codegym.phonemanagementajaxwebservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producer;
    private String model;
    private double price;

}