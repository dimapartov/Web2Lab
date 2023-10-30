package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.BrandDTO;

public interface BrandService {

    BrandDTO addBrand(BrandDTO brandDTO);
    void deleteBrandByName(String name);
//----------------------------------------------------------------------------------------------------------------------
//    void registerBrand(BrandDTO brandDTO);
}