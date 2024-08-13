package com.codegym.thimodul4.dto;

import com.codegym.thimodul4.models.ProductType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;
@Data
public class OrderDTO {
    private Long id;
    private String orderCode;
    private Long product;
    private Double price;
    private ProductType productType;

    @NotNull(message = "Ngày giao dịch bắt buộc")
    @PastOrPresent(message = "Ngày giao dịch không được ở tương lai")
    private LocalDate purchaseDate;

    @NotNull(message = "Đơn giá bắt buộc")
    @Min(value = 500000, message = "Đơn giá phải lớn hơn 500,000 VND")
    private Integer quantity;
    private int totalAmount;
}
