package com.codegym.customerprovincemanagement.service.province;

import com.codegym.customerprovincemanagement.model.Province;

public interface IProvinceService {
    Iterable<Province> findAll();
}
