package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.models.Offer;
import com.example.websecondlab.repositories.OfferRepository;
import com.example.websecondlab.services.OfferService;
import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.web.view.OffersDemoView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OfferRepository offerRepository;


    @Override
    public void addOffer(OfferDTO offerDTO) {
        Offer offer = modelMapper.map(offerDTO, Offer.class);
        offerRepository.saveAndFlush(offer);
    }

    @Override
    public void deleteOfferById(long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public List<OfferDTO> getOffersByMileageLowerThan(int mileage) {
        return offerRepository.findAllByMileageLessThan(mileage)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getOffersByPriceLowerThan(BigDecimal price) {
        return offerRepository.findAllByPriceLessThan(price)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getOffersByEngineType(String engineType) {
        return offerRepository.findAllByEngineType(EngineTypeEnum.valueOf(engineType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getOffersByTransmissionType(String transmissionType) {
        return offerRepository.findAllByTransmissionType(TransmissionTypeEnum.valueOf(transmissionType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getOffersBySeller(String username) {
        return offerRepository.findAllBySellerUsername(username)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public List<OffersDemoView> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDemoView> getAllOffersByMileageLowerThan(int mileage) {
        return offerRepository.findAllByMileageLessThan(mileage)
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDemoView> getAllOffersByPriceLowerThan(BigDecimal price) {
        return offerRepository.findAllByPriceLessThan(price)
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDemoView> getAllOffersByEngineType(String engineType) {
        return offerRepository.findAllByEngineType(EngineTypeEnum.valueOf(engineType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDemoView> getAllOffersByTransmissionType(String transmissionType) {
        return offerRepository.findAllByTransmissionType(TransmissionTypeEnum.valueOf(transmissionType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoView.class))
                .collect(Collectors.toList());
    }
}