package com.codegym.repositories;

import com.codegym.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
public class ProductRepo implements IProductRepo {
    private static final List<Product> products = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> showAll() {
        List<Product> products = entityManager.createQuery("select p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where  p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> searchProductByName(String keyword) {
        List<Product> products = entityManager.createQuery("select p from Product p where name like :name", Product.class).setParameter("name","%" + keyword + "%").getResultList();
        return products;
    }

}
