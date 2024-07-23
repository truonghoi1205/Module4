package com.codegym.customerprovincemanagement.repository;

import com.codegym.customerprovincemanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {
    @Query(nativeQuery = true, value = "select * from customers as c where c.last_name like :lastName")
    Page<Customer> findAllByNameContaining(@Param("lastName") String lastName, Pageable pageable);
}
