package com.codegym.customerprovincemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "provinces")
@Data
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
}
