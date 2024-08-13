package com.codegym.thimodul4.services;

import com.codegym.thimodul4.dto.OrderDTO;
import com.codegym.thimodul4.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAllOrderDTOs();
    }
}
