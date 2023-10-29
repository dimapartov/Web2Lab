package com.example.websecondlab.web.controllers;

import com.example.websecondlab.services.OfferService;
import com.example.websecondlab.web.view.OffersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("")
    public String getAllOffers(Model model) {
        List<OffersView> allOffers = offerService.getAllOffers();
        model.addAttribute("allOffers", allOffers);
        return "all-offers-page";
    }

    @GetMapping("/by-mileage")
    public String getAllOffersByMileage(@RequestParam int mileage, Model model) {
        List<OffersView> allOffersByMileageLowerThan = offerService.getAllOffersByMileageLowerThan(mileage);
        model.addAttribute("allOffers", allOffersByMileageLowerThan);
        return "all-offers-by-mileage-page";
    }
}