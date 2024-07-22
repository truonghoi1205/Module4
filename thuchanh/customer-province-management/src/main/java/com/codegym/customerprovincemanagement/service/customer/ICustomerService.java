package com.codegym.customerprovincemanagement.service.customer;

import com.codegym.customerprovincemanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);


    Customer findById(Long id);

    void deleteById(Long id);
}
