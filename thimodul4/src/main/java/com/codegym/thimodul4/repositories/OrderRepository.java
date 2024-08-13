package com.codegym.thimodul4.repositories;

import com.codegym.thimodul4.models.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface OrderRepository extends JpaRepository<Orders, Long> {


}
