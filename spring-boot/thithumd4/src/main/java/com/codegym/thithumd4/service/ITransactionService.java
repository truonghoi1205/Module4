package com.codegym.thithumd4.service;

import com.codegym.thithumd4.model.ServiceType;
import com.codegym.thithumd4.model.Transaction;

public interface ITransactionService {
    Iterable<Transaction> findAll();

    void save(Transaction transaction);

    Transaction findTransactionById(Long id);

    void deleteById(Long id);

    Iterable<Transaction> searchTransactions(String customerName, ServiceType serviceType);
    boolean checkTransactionCodeExists(String code);
}
