package com.example.websecondlab.web.controllers;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.services.BrandService;
import com.example.websecondlab.web.view.OfferDemoViewModel;
import com.example.websecondlab.web.view.user_input.CreateOfferViewModel;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.websecondlab.services.OfferService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;
    private BrandService brandService;

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/")
    public String getAllOffers(Model model) {
        LOG.log(Level.INFO, "Show all offers");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        model.addAttribute("allOffers", offerService.getAllOffers());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "offers-all";
    }

/*    @GetMapping("/by-model/{modelName}")
    public String getAllOffersByModel(@PathVariable String modelName, Model model) {
        LOG.log(Level.INFO, "Show offers by model: " + modelName);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        model.addAttribute("allOffers", offerService.getAllOffersByModel(modelName));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "offers-all";
    }*/

    @GetMapping("/details/{offerId}")
    public String getOfferInfo(@PathVariable long offerId, Model model) {
        LOG.log(Level.INFO, "Show details for offer with offer id: " + offerId);
        model.addAttribute("offerWithInfo", offerService.getOfferInfo(offerId));
        return "offers-full-info";
    }

    @GetMapping("/filtered")
    public String getFilteredOffers(@RequestParam Optional<List<String>> engineTypes,
                                    @RequestParam Optional<List<String>> transmissionTypes,
                                    @RequestParam Optional<List<String>> categories,
                                    @RequestParam(required = false) String modelName, Model model) {

        LOG.log(Level.INFO, "Show all offers with filters: " + engineTypes + " " + transmissionTypes + " " + categories + " " + modelName);
        model.addAttribute("allOffers", offerService.getFilteredOffers(engineTypes, transmissionTypes, categories, modelName));
        return "offers-all";
    }


    @GetMapping("/create")
    public String createOffer(Model model) {
        model.addAttribute("brands", brandService.getAll());
        model.addAttribute("transmissions", List.of(TransmissionTypeEnum.values()));
        model.addAttribute("engines", List.of(EngineTypeEnum.values()));
        return "offers-create";
    }
    @ModelAttribute("newOfferModel")
    public CreateOfferViewModel initOffer() {
        return new CreateOfferViewModel();
    }
    @PostMapping("/create")
    public String createOffer(@Valid CreateOfferViewModel newOfferModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        LOG.log(Level.INFO, "Create offer by" + newOfferModel.getSeller());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newOfferModel", newOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newOfferModel", bindingResult);
            return "redirect:/offers/create";
        }
        offerService.createOffer(newOfferModel);
        return "redirect:/offers/";
    }

    @GetMapping("/top-10-cheapest-by-model")
    public String getTop10CheapestOffersForModel(Model model) {
        LOG.log(Level.INFO, "Show top 10 cheapest offers by popular model");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        model.addAttribute("allOffers", offerService.getTop10CheapestOffersForModel());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "offers-all";
    }
}