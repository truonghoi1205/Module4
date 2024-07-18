package com.codegym.services;

import com.codegym.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void update(Product product);
}
