package com.codegym.thithumd4.repository;

import com.codegym.thithumd4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer,Long> {
}
