package com.codegym.thithumd4.dto;

import com.codegym.thithumd4.model.Customer;
import com.codegym.thithumd4.model.ServiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Date;
@Data
public class TransactionDto {
    private Long id;

    @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch không đúng định dạng (MGD-XXXX)")
    @NotBlank(message = "Mã giao dịch bắt buộc")
    private String code;

    @NotNull(message = "Ngày giao dịch bắt buộc")
    @PastOrPresent(message = "Ngày giao dịch không được ở tương lai")
    private Date date;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType = ServiceType.LAND;

    @NotNull(message = "Đơn giá bắt buộc")
    @Min(value = 500000, message = "Đơn giá phải lớn hơn 500,000 VND")
    @NumberFormat(pattern = "#,###.##")
    private double price;

    @NotNull(message = "Diện tích không được để trống")
    @Min(value = 21, message = "Diện tích phải lớn hơn 20 m²")
    @NumberFormat(pattern = "#,###.##")
    private double acreage;

    private Customer customer;
}
