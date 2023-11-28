package com.example.websecondlab.web.controllers;

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
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;


    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("")
    public String getAllOffers(Model model) {
        model.addAttribute("allOffers", offerService.getAllOffers());
        return "offers-all";
    }

//    @GetMapping("/by-mileage")
//    public String getAllOffersByMileageLowerThan(@RequestParam int mileage, Model model) {
//        List<OffersDemoViewModel> allOffersByMileageLowerThan = offerService.getAllOffersByMileageLowerThan(mileage);
//        model.addAttribute("allOffers", allOffersByMileageLowerThan);
//        allOffersByMileageLowerThan.forEach(System.out::println);
//        return "all-offers-by-mileage";
//    }
//
//    @GetMapping("/by-price")
//    public String getAllOffersByPriceLowerThan(@RequestParam BigDecimal price, Model model) {
//        List<OffersDemoViewModel> allOffersByPriceLowerThan = offerService.getAllOffersByPriceLowerThan(price);
//        model.addAttribute("allOffers", allOffersByPriceLowerThan);
//        allOffersByPriceLowerThan.forEach(System.out::println);
//        return "all-offers-by-price";
//    }
//
//    @GetMapping("/by-engine")
//    public String getAllOffersByEngineType(@RequestParam String engineType, Model model) {
//        List<OffersDemoViewModel> allOffersByEngineType = offerService.getAllOffersByEngineType(engineType);
//        model.addAttribute("allOffers", allOffersByEngineType);
//        allOffersByEngineType.forEach(System.out::println);
//        return "all-offers-by-engine";
//    }
//
//    @GetMapping("/by-transmission")
//    public String getAllOffersByTransmissionType(@RequestParam String transmissionType, Model model) {
//        List<OffersDemoViewModel> allOffersByTransmissionType = offerService.getAllOffersByTransmissionType(transmissionType);
//        model.addAttribute("allOffers", allOffersByTransmissionType);
//        allOffersByTransmissionType.forEach(System.out::println);
//        return "all-offers-by-transmission";
//    }

    @PostMapping("/new")
    public String createOffer(@RequestBody CreateOfferViewModel newOffer, Model model) {
        offerService.createOffer(newOffer);
        model.addAttribute("newOffer", newOffer);
        return "offers-create";
    }
}