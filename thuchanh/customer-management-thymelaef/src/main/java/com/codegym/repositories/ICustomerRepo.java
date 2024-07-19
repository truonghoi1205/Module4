package com.codegym.repositories;

import com.codegym.models.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> showAll();

    void save(Customer customer);

    void delete(int id);

    Customer findById(int id);

}
