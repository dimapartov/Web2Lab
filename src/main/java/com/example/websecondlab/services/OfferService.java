package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.OfferDTO;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    OfferDTO addOffer(OfferDTO offerDTO);
    void deleteOfferById(long id);

    List<OfferDTO> getOffersByMileageLowerThan(int mileage);
    List<OfferDTO> getOffersByPriceLowerThan(BigDecimal price);
    List<OfferDTO> getOffersByEngineType(String engineType);
    List<OfferDTO> getOffersByTransmissionType(String transmissionType);
    List<OfferDTO> getOffersBySeller(String username);
}