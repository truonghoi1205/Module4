package com.codegym.customer_marnager.repositories;

import com.codegym.customer_marnager.models.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
