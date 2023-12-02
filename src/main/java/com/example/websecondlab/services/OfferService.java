package com.example.websecondlab.services;

import java.math.BigDecimal;
import java.util.List;

import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.web.view.OfferDemoViewModel;
import com.example.websecondlab.web.view.OfferFullViewModel;
import com.example.websecondlab.web.view.user_input.CreateOfferViewModel;

public interface OfferService {

    void addOffer(OfferDTO offerDTO);
    void deleteOfferById(long id);

    List<OfferDTO> getOffersByMileageLowerThan(int mileage);
    List<OfferDTO> getOffersByPriceLowerThan(BigDecimal price);
    List<OfferDTO> getOffersByEngineType(String engineType);
    List<OfferDTO> getOffersByTransmissionType(String transmissionType);
    List<OfferDTO> getOffersBySeller(String username);
//----------------------------------------------------------------------------------------------------------------------
//    Business

    List<OfferDemoViewModel> getAllOffersByMileageLowerThan(int mileage);
    List<OfferDemoViewModel> getAllOffersByPriceLowerThan(BigDecimal price);
    List<OfferDemoViewModel> getAllOffersByEngineType(String engineType);
    List<OfferDemoViewModel> getAllOffersByTransmissionType(String transmissionType);
    void createOffer(CreateOfferViewModel newOffer);

    List<OfferDemoViewModel> getAllOffers();
    List<OfferDemoViewModel> getAllOffersByModel(String modelName);
    OfferFullViewModel getOfferInfo(long offerId);
}