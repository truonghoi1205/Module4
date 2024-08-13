package com.codegym.thimodul4.services;

import com.codegym.thimodul4.models.ProductType;
import com.codegym.thimodul4.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService{

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
