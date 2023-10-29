package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.ModelDTO;

import java.util.List;

public interface ModelService {

    ModelDTO addModel(ModelDTO modelDTO);
    void deleteModelById(long id);

    List<ModelDTO> getAllModels();
    List<ModelDTO> getModelsByCategory(String category);
    List<ModelDTO> getModelsByBrand(String brandName);
}