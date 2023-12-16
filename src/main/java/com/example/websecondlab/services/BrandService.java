package com.example.websecondlab.services;

import java.util.List;

import com.example.websecondlab.services.dtos.BrandDTO;
import com.example.websecondlab.web.view.BrandViewModel;

public interface BrandService {

    /*BrandDTO addBrand(BrandDTO brandDTO);
    void deleteBrandByName(String name);*/

//----------------------------------------------------------------------------------------------------------------------
//    Business

    List<BrandViewModel> getAllBrands();
    List<BrandDTO> getAll();
}