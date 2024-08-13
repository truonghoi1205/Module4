package com.codegym.thimodul4.services;

import com.codegym.thimodul4.models.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long product);
}
