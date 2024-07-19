package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        return customerRepo.saveWithStoredProcedure(customer);
    }
}
