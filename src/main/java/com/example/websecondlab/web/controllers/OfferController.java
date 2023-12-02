package com.example.websecondlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.websecondlab.services.OfferService;

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

    @GetMapping("/by-model/{modelName}")
    public String getAllOffersByModel(@PathVariable String modelName, Model model) {
        model.addAttribute("allOffers", offerService.getAllOffersByModel(modelName));
        return "offers-all";
    }

    @GetMapping("/details/{offerId}")
    public String getOfferInfo(@PathVariable long offerId, Model model) {
        model.addAttribute("offerWithInfo", offerService.getOfferInfo(offerId));
        return "offers-full-info";
    }

//    @GetMapping("/by-mileage")
//    public String getAllOffersByMileageLowerThan(@RequestParam int mileage, Model model) {
//        List<OfferDemoViewModel> allOffersByMileageLowerThan = offerService.getAllOffersByMileageLowerThan(mileage);
//        model.addAttribute("allOffers", allOffersByMileageLowerThan);
//        allOffersByMileageLowerThan.forEach(System.out::println);
//        return "all-offers-by-mileage";
//    }

//    @GetMapping("/by-price")
//    public String getAllOffersByPriceLowerThan(@RequestParam BigDecimal price, Model model) {
//        List<OfferDemoViewModel> allOffersByPriceLowerThan = offerService.getAllOffersByPriceLowerThan(price);
//        model.addAttribute("allOffers", allOffersByPriceLowerThan);
//        allOffersByPriceLowerThan.forEach(System.out::println);
//        return "all-offers-by-price";
//    }

//    @GetMapping("/by-engine")
//    public String getAllOffersByEngineType(@RequestParam String engineType, Model model) {
//        List<OfferDemoViewModel> allOffersByEngineType = offerService.getAllOffersByEngineType(engineType);
//        model.addAttribute("allOffers", allOffersByEngineType);
//        allOffersByEngineType.forEach(System.out::println);
//        return "all-offers-by-engine";
//    }

//    @GetMapping("/by-transmission")
//    public String getAllOffersByTransmissionType(@RequestParam String transmissionType, Model model) {
//        List<OfferDemoViewModel> allOffersByTransmissionType = offerService.getAllOffersByTransmissionType(transmissionType);
//        model.addAttribute("allOffers", allOffersByTransmissionType);
//        allOffersByTransmissionType.forEach(System.out::println);
//        return "all-offers-by-transmission";
//    }

//     @PostMapping("/new")
//     public String createOffer(@RequestBody CreateOfferViewModel newOffer, Model model) {
//         offerService.createOffer(newOffer);
//         model.addAttribute("newOffer", newOffer);
//         return "offers-create";
//     }
}