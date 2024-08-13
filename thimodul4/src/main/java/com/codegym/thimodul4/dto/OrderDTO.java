package com.codegym.thimodul4.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrderDTO {
    private Long id;
    private String orderCode;
    private String productName;
    private Double price;
    private String productType;
    private LocalDate purchaseDate;
    private Integer quantity;
    private int totalAmount;


}
