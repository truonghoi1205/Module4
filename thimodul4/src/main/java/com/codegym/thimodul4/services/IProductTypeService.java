package com.codegym.thimodul4.services;

import com.codegym.thimodul4.models.ProductType;

public interface IProductTypeService {
    Iterable<ProductType> findAll();
}
