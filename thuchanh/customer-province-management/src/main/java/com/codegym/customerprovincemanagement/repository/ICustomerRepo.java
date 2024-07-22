package com.codegym.customerprovincemanagement.repository;

import com.codegym.customerprovincemanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {
}
