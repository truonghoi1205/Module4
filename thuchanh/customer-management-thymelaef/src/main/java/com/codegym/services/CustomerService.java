package com.codegym.services;

import com.codegym.models.Customer;
import com.codegym.repositories.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> showAll() {
        return customerRepo.showAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepo.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id,customer);
    }
}
