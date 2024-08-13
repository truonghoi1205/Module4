package com.codegym.thimodul4.repositories;

import com.codegym.thimodul4.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
