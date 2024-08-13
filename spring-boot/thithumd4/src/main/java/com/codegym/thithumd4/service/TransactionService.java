package com.codegym.thithumd4.service;

import com.codegym.thithumd4.model.ServiceType;
import com.codegym.thithumd4.model.Transaction;
import com.codegym.thithumd4.repository.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepo transactionRepo;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepo.findAll();
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepo.deleteById(id);
    }

    @Override
    public Iterable<Transaction> searchTransactions(String customerName, ServiceType serviceType) {
        if (customerName != null && serviceType != null) {
            return transactionRepo.findByCustomerNameContainingAndServiceType(customerName, serviceType);
        } else if (customerName != null) {
            return transactionRepo.findByCustomerNameContaining(customerName);
        } else if (serviceType != null) {
            return transactionRepo.findByServiceType(serviceType);
        } else {
            return transactionRepo.findAll();
        }
    }

    @Override
    public boolean checkTransactionCodeExists(String code) {
        return transactionRepo.findTransactionByCode(code) != null;
    }
}
