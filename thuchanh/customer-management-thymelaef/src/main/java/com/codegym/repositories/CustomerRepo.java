package com.codegym.repositories;

import com.codegym.models.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;
@Transactional
@Repository
public class CustomerRepo implements ICustomerRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> showAll() {
        List<Customer> customers = entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
        return customers;
    }

    @Override
    public void save(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
