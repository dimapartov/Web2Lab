package com.example.websecondlab.services;

import java.math.BigDecimal;
import java.util.List;

import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.web.view.OffersDemoViewModel;
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

//    Display offers
    List<OffersDemoViewModel> getAllOffers();
    List<OffersDemoViewModel> getAllOffersByMileageLowerThan(int mileage);
    List<OffersDemoViewModel> getAllOffersByPriceLowerThan(BigDecimal price);
    List<OffersDemoViewModel> getAllOffersByEngineType(String engineType);
    List<OffersDemoViewModel> getAllOffersByTransmissionType(String transmissionType);
    List<OffersDemoViewModel> getAllOffersByModel(String modelName);
//    Create offer
    void createOffer(CreateOfferViewModel newOffer);
}