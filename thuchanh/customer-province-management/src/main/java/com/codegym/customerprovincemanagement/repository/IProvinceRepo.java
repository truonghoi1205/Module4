package com.codegym.customerprovincemanagement.repository;

import com.codegym.customerprovincemanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepo extends JpaRepository<Province,Long> {
}
