package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.web.view.ModelByBrandViewModel;

import java.util.List;

public interface ModelService {

    void addModel(ModelDTO modelDTO);
    void deleteModelById(long id);

    List<ModelDTO> getAllModels();
    List<ModelDTO> getModelsByCategory(String category);
    List<ModelDTO> getModelsByBrand(String brandName);
//----------------------------------------------------------------------------------------------------------------------
//    Business

    List<ModelByBrandViewModel> getAllModelsByBrand(String brandName);
}