package com.codegym.services;

import com.codegym.models.Product;
import com.codegym.repositories.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> showAll() {
        return productRepo.showAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        productRepo.delete(id);
    }

    @Override
    public List<Product> searchProductByName(String keyword) {
        return productRepo.searchProductByName(keyword);
    }

}