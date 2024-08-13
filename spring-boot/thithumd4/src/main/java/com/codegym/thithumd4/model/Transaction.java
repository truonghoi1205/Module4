package com.codegym.thithumd4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date date;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    private double price;
    private double acreage;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
