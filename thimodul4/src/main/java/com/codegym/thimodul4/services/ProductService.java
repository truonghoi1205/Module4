package com.codegym.thimodul4.services;

import com.codegym.thimodul4.models.Product;
import com.codegym.thimodul4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long product) {
        return productRepository.findById(product).orElse(null);
    }
}
