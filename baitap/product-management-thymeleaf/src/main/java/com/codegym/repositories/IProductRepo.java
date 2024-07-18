package com.codegym.repositories;

import com.codegym.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> showAll();

    void save(Product product);

    Product findById(Long id);

    void delete(Long id);

    List<Product> searchProductByName(String keyword);

}
