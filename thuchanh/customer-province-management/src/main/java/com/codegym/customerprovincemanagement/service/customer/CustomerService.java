package com.codegym.customerprovincemanagement.service.customer;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }
}
