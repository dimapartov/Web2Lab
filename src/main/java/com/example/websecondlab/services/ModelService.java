package com.example.websecondlab.services;

import java.util.List;

import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.web.view.ModelByBrandViewModel;

public interface ModelService {

    /*void addModel(ModelDTO modelDTO);
    void deleteModelById(long id);
    List<ModelDTO> getAllModels();
    List<ModelDTO> getModelsByCategory(String category);
    List<ModelDTO> getModelsByBrand(String brandName);*/

//----------------------------------------------------------------------------------------------------------------------
//    Business

    List<ModelByBrandViewModel> getAllModelsByBrand(String brandName);
}