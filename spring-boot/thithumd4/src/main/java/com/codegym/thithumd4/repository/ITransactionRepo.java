package com.codegym.thithumd4.repository;

import com.codegym.thithumd4.model.ServiceType;
import com.codegym.thithumd4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepo extends JpaRepository<Transaction,Long> {

    Iterable<Transaction> findByCustomerNameContainingAndServiceType(String customerName, ServiceType serviceType);

    Iterable<Transaction> findByCustomerNameContaining(String customerName);

    Iterable<Transaction> findByServiceType(ServiceType serviceType);

    Transaction findTransactionByCode(String code);
}
