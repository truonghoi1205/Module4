package com.codegym.services;

import com.codegym.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showAll();

    void save(Customer customer);

    void delete(int id);

    Customer findById(int id);

    void update(int id, Customer customer);
}
