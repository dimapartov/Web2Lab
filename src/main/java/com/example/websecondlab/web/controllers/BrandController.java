package com.example.websecondlab.web.controllers;

import com.example.websecondlab.services.BrandService;
import com.example.websecondlab.services.OfferService;
import com.example.websecondlab.web.view.OffersDemoViewModel;
import com.example.websecondlab.web.view.user_input.CreateOfferViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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