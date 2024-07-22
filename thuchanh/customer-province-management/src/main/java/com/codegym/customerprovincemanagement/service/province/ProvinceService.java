package com.codegym.customerprovincemanagement.service.province;

import com.codegym.customerprovincemanagement.model.Province;
import com.codegym.customerprovincemanagement.repository.IProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService implements IProvinceService{

    @Autowired
    private IProvinceRepo provinceRepo;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }
}
