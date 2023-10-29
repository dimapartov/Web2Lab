package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.models.Model;
import com.example.websecondlab.repositories.ModelRepository;
import com.example.websecondlab.services.ModelService;
import com.example.websecondlab.consts.enums.CategoryEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;


    @Override
    public ModelDTO addModel(ModelDTO modelDTO) {
        Model model = modelMapper.map(modelDTO, Model.class);
        modelRepository.save(model);
        return modelMapper.map(model, ModelDTO.class);
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
    }
}