package com.codegym.repositories;

import com.codegym.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> showAll();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void update( Product product);

    List<Product> searchProductByName(String keyword);
}
