package com.example.websecondlab.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.websecondlab.web.view.OfferDemoViewModel;
import com.example.websecondlab.web.view.OfferFullViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.models.Model;
import com.example.websecondlab.models.Offer;
import com.example.websecondlab.models.User;
import com.example.websecondlab.repositories.ModelRepository;
import com.example.websecondlab.repositories.OfferRepository;
import com.example.websecondlab.repositories.UserRepository;
import com.example.websecondlab.services.OfferService;
import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.web.view.user_input.CreateOfferViewModel;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private OfferRepository offerRepository;
    private ModelRepository modelRepository;
    private UserRepository userRepository;

    @Autowired
    public OfferServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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
//    Business

/*
    @Override
    public List<OfferDemoViewModel> getAllOffersByMileageLowerThan(int mileage) {

        List<OfferDTO> allOffersByMileageDtoList = offerRepository.findAllByMileageLessThan(mileage)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByMileageDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }
    @Override
    public List<OfferDemoViewModel> getAllOffersByPriceLowerThan(BigDecimal price) {
        List<OfferDTO> allOffersByPriceDtoList = offerRepository.findAllByPriceLessThan(price)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByPriceDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }
    @Override
    public List<OfferDemoViewModel> getAllOffersByEngineType(String engineType) {

        List<OfferDTO> allOffersByEngineDtoList = offerRepository.findAllByEngineType(EngineTypeEnum.valueOf(engineType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByEngineDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }
    @Override
    public List<OfferDemoViewModel> getAllOffersByTransmissionType(String transmissionType) {

        List<OfferDTO> allOffersByTransmissionDtoList = offerRepository.findAllByTransmissionType(TransmissionTypeEnum.valueOf(transmissionType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByTransmissionDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }
*/

    @Override
    public List<OfferDemoViewModel> getAllOffers() {

        List<OfferDTO> allOffersDtoList = offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }

    @Override
    public List<OfferDemoViewModel> getAllOffersByModel(String modelName) {
        List<OfferDTO> allOffersDtoList = offerRepository.findAllByModelName(modelName)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OfferDemoViewModel> allOfferDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersDtoList) {

            OfferDemoViewModel offerDemoView = modelMapper.map(offerDto, OfferDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOfferDemoViewModel.add(offerDemoView);
        }
        return allOfferDemoViewModel;
    }

    @Override
    public OfferFullViewModel getOfferInfo(long offerId) {
        return modelMapper.map(offerRepository.getOfferFullInfo(offerId), OfferFullViewModel.class);
    }

//    TODO
//    @Override
//    public void createOffer(CreateOfferViewModel newOffer) {
//        Offer newOfferModel = modelMapper.map(newOffer, Offer.class);
//        Model model = modelRepository.findModelByName(newOffer.getModel());
//        Optional<User> seller = userRepository.findUserByUsername(newOffer.getSeller());
//        newOfferModel.setModel(model);
//        newOfferModel.setSeller(seller);
//        newOfferModel.setTransmissionType(TransmissionTypeEnum.valueOf(newOffer.getTransmissionType().toUpperCase()));
//        newOfferModel.setEngineType(EngineTypeEnum.valueOf(newOffer.getEngineType().toUpperCase()));
//        offerRepository.saveAndFlush(newOfferModel);
//    }
}