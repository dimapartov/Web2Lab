package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.dtos.BrandDTO;
import com.example.websecondlab.models.Brand;
import com.example.websecondlab.repositories.BrandRepository;
import com.example.websecondlab.services.BrandService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void registerBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        brandRepository.saveAndFlush(brand);
    }

    @Override
    public BrandDTO addBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        return modelMapper.map(brandRepository.saveAndFlush(brand), BrandDTO.class);
    }

    @Override
    @Transactional
    public void deleteBrandByName(String name) {
        brandRepository.deleteBrandByName(name);
    }
}