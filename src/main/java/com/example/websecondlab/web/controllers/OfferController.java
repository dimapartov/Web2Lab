package com.example.websecondlab.web.controllers;

import com.example.websecondlab.web.view.user_input.CreateOfferViewModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.websecondlab.services.OfferService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

/*
    @GetMapping("/create")
    public String createOffer() {
        return "offers-create";
    }

    @ModelAttribute("newOfferModel")
    public CreateOfferViewModel initOffer() {
        return new CreateOfferViewModel();
    }

    @PostMapping("/create")
    public String createOffer(@Valid CreateOfferViewModel newOfferModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newOfferModel", newOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newOfferModel", bindingResult);
            return "redirect:/offers/create";
        }
        // offerService.createOffer
        return "redirect:/offers/";
    }

 */
}