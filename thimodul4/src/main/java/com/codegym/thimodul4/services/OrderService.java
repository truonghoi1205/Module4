package com.codegym.thimodul4.services;

import com.codegym.thimodul4.dto.OrderDTO;
import com.codegym.thimodul4.models.Orders;
import com.codegym.thimodul4.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    public Page<Orders> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Orders findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }
}
