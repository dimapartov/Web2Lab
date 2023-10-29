package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.web.view.OffersDemoView;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    void addOffer(OfferDTO offerDTO);
    void deleteOfferById(long id);

    List<OfferDTO> getOffersByMileageLowerThan(int mileage);
    List<OfferDTO> getOffersByPriceLowerThan(BigDecimal price);
    List<OfferDTO> getOffersByEngineType(String engineType);
    List<OfferDTO> getOffersByTransmissionType(String transmissionType);
    List<OfferDTO> getOffersBySeller(String username);
//----------------------------------------------------------------------------------------------------------------------
    List<OffersDemoView> getAllOffers();
    List<OffersDemoView> getAllOffersByMileageLowerThan(int mileage);
    List<OffersDemoView> getAllOffersByPriceLowerThan(BigDecimal price);
    List<OffersDemoView> getAllOffersByEngineType(String engineType);
    List<OffersDemoView> getAllOffersByTransmissionType(String transmissionType);
}