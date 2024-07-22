package com.codegym.customerprovincemanagement.service.customer;

import com.codegym.customerprovincemanagement.model.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();
}
