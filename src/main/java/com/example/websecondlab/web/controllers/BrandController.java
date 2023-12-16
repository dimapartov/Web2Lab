package com.example.websecondlab.web.controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.websecondlab.services.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/")
    public String getAllBrands(Model model) {
        LOG.log(Level.INFO, "Show all brands");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        model.addAttribute("allBrands", brandService.getAllBrands());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "brands-all";
    }
}