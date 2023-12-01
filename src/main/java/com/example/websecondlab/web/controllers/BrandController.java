package com.example.websecondlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.websecondlab.services.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/")
    public String getAllBrands(Model model) {
        model.addAttribute("allBrands", brandService.getAllBrands());
        return "brands-all";
    }
}