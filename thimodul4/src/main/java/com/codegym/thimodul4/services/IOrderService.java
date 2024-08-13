package com.codegym.thimodul4.services;

import com.codegym.thimodul4.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface IOrderService {
    Page<Orders> getAllOrders(Pageable pageable);

    Orders findById(Long id);

    void save(Orders orders);
}
