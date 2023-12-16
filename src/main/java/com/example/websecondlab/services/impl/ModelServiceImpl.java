package com.example.websecondlab.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.models.Model;
import com.example.websecondlab.repositories.ModelRepository;
import com.example.websecondlab.services.ModelService;
import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.web.view.ModelByBrandViewModel;

@Service
@EnableCaching
public class ModelServiceImpl implements ModelService {

    private final ModelMapper modelMapper;
    private ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    /*@Override
    public void addModel(ModelDTO modelDTO) {
        Model model = modelMapper.map(modelDTO, Model.class);
        modelRepository.saveAndFlush(model);
    }

    @Override
    public void deleteModelById(long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<ModelDTO> getAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(model -> modelMapper.map(model, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> getModelsByCategory(String category) {
        return modelRepository.findAllByCategory(CategoryEnum.valueOf(category.toUpperCase()))
                .stream()
                .map(model -> modelMapper.map(model, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> getModelsByBrand(String brandName) {
        return modelRepository.findAllByBrandName(brandName)
                .stream()
                .map(model -> modelMapper.map(model, ModelDTO.class))
                .collect(Collectors.toList());
    }*/

//----------------------------------------------------------------------------------------------------------------------
//    Business

    @Cacheable(value = "models", key = "#root.methodName + '_' + #brandName")
    @Override
    public List<ModelByBrandViewModel> getAllModelsByBrand(String brandName) {
        List<ModelByBrandViewModel> modelsByBrand = modelRepository.findAllModelsByBrandName(brandName);
        return  modelsByBrand;
    }
}