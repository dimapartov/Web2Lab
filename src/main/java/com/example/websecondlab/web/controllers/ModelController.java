package com.example.websecondlab.web.controllers;

import com.example.websecondlab.web.view.ModelByBrandViewModel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.websecondlab.services.ModelService;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelController {

    private ModelService modelService;

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }


    @GetMapping("/by-brand/{brandName}")
    public String getAllModelsByBrand(@PathVariable String brandName, Model model) {
        LOG.log(Level.INFO, "Show models by brand: " + brandName);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        model.addAttribute("allModelsByBrand", modelService.getAllModelsByBrand(brandName));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "models-by-brand";
    }

    @GetMapping("/by-brand-name/{brandName}")
    public ResponseEntity<List<ModelByBrandViewModel>> getAllModelsByBrandName(@PathVariable String brandName) {
        List<ModelByBrandViewModel> modelsByBrand = modelService.getAllModelsByBrand(brandName);
        return ResponseEntity.status(200).body(modelsByBrand);
    }
}