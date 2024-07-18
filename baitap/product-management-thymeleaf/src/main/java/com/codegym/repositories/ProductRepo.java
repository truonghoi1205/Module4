package com.codegym.repositories;

import com.codegym.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Giấy", 3000, "Đây là giấy", "Việt Nam"));
        products.add(new Product("Bánh", 5000, "Đây là bánh", "Trung Quốc"));
    }

    @Override
    public List<Product> showAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        products.remove(findById(id));
    }

    @Override
    public void update( Product product) {
        Product p = findById(product.getId());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        p.setProducer(product.getProducer());
    }

    @Override
    public List<Product> searchProductByName(String keyword) {
        List<Product> productsNew = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(keyword)) {
                productsNew.add(product);
            }
        }
        return productsNew;
    }
}
