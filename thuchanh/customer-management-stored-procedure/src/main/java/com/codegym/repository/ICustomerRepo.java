package com.codegym.repository;

import com.codegym.model.Customer;

public interface ICustomerRepo {
    boolean saveWithStoredProcedure(Customer customer);
}
