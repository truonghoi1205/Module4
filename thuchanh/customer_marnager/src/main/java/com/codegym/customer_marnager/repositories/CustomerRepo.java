package com.codegym.customer_marnager.repositories;

import com.codegym.customer_marnager.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo{

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1L,"Nguyen Khac Nhat","nhat@gmail.com","Hà Nội"));
        customers.add(new Customer(2L,"Dang Huy Hoa","hoa.dang@gmail.com","Đà Nẵng"));
        customers.add(new Customer(3L,"Le Thi Chau","chau.le@gmail.com","Hà Nội"));
        customers.add(new Customer(4L,"Nguyen Thuy Duong","duong.nguyen@gmail.com","Sài Gòn"));
        customers.add(new Customer(5L,"CodeGym","codegym@gmail.com","Việt Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        Customer c = findById(customer.getId());
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setAddress(customer.getAddress());
    }

}
