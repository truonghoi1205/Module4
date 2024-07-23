package com.codegym.customerprovincemanagement.service.customer;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByName(String lastName, Pageable pageable) {
        return customerRepo.findAllByNameContaining("%"+ lastName +"%", pageable);
    }


}
