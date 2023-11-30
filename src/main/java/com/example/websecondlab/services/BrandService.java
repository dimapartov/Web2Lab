package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.BrandDTO;
import com.example.websecondlab.web.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    BrandDTO addBrand(BrandDTO brandDTO);
    void deleteBrandByName(String name);
//----------------------------------------------------------------------------------------------------------------------
//    Business

    List<BrandViewModel> getAllBrands();
}