package com.codegym.thimodul4.repositories;

import com.codegym.thimodul4.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
