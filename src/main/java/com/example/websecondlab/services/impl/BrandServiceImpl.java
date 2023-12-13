package com.example.websecondlab.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.websecondlab.models.Brand;
import com.example.websecondlab.repositories.BrandRepository;
import com.example.websecondlab.services.BrandService;
import com.example.websecondlab.services.dtos.BrandDTO;
import com.example.websecondlab.web.view.BrandViewModel;

import jakarta.transaction.Transactional;

@Service
@EnableCaching
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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
//----------------------------------------------------------------------------------------------------------------------
//    Business

    @Cacheable(value = "brands", key = "#root.methodName")
    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> allBrands = brandRepository.findAll()
                .stream()
                .map(brand -> modelMapper.map(brand, BrandViewModel.class))
                .toList();
        return allBrands;
    }

    @Override
    public List<BrandDTO> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .toList();
    }
}