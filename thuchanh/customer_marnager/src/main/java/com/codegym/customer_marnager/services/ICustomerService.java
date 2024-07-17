package com.codegym.customer_marnager.services;

import com.codegym.customer_marnager.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
