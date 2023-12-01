package com.example.websecondlab.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.websecondlab.web.view.OffersDemoViewModel;
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

    @Override
    public List<OffersDemoViewModel> getAllOffers() {

        List<OfferDTO> allOffersDtoList = offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OffersDemoViewModel> allOffersDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersDtoList) {

            OffersDemoViewModel offerDemoView = modelMapper.map(offerDto, OffersDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoViewModel.add(offerDemoView);
        }
        return allOffersDemoViewModel;
    }

    @Override
    public List<OffersDemoViewModel> getAllOffersByMileageLowerThan(int mileage) {

        List<OfferDTO> allOffersByMileageDtoList = offerRepository.findAllByMileageLessThan(mileage)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OffersDemoViewModel> allOffersDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByMileageDtoList) {

            OffersDemoViewModel offerDemoView = modelMapper.map(offerDto, OffersDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoViewModel.add(offerDemoView);
        }
        return allOffersDemoViewModel;
    }

    @Override
    public List<OffersDemoViewModel> getAllOffersByPriceLowerThan(BigDecimal price) {
        List<OfferDTO> allOffersByPriceDtoList = offerRepository.findAllByPriceLessThan(price)
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OffersDemoViewModel> allOffersDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByPriceDtoList) {

            OffersDemoViewModel offerDemoView = modelMapper.map(offerDto, OffersDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoViewModel.add(offerDemoView);
        }
        return allOffersDemoViewModel;
    }

    @Override
    public List<OffersDemoViewModel> getAllOffersByEngineType(String engineType) {

        List<OfferDTO> allOffersByEngineDtoList = offerRepository.findAllByEngineType(EngineTypeEnum.valueOf(engineType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OffersDemoViewModel> allOffersDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByEngineDtoList) {

            OffersDemoViewModel offerDemoView = modelMapper.map(offerDto, OffersDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoViewModel.add(offerDemoView);
        }
        return allOffersDemoViewModel;
    }

    @Override
    public List<OffersDemoViewModel> getAllOffersByTransmissionType(String transmissionType) {

        List<OfferDTO> allOffersByTransmissionDtoList = offerRepository.findAllByTransmissionType(TransmissionTypeEnum.valueOf(transmissionType.toUpperCase()))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .toList();

        List<OffersDemoViewModel> allOffersDemoViewModel = new ArrayList<>();

        for (OfferDTO offerDto : allOffersByTransmissionDtoList) {

            OffersDemoViewModel offerDemoView = modelMapper.map(offerDto, OffersDemoViewModel.class);

            offerDemoView.setModel(offerDto.getModel().getName());
            offerDemoView.setBrand(offerDto.getModel().getBrand().getName());
            offerDemoView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoViewModel.add(offerDemoView);
        }
        return allOffersDemoViewModel;
    }

    @Override
    public void createOffer(CreateOfferViewModel newOffer) {
//        If view model is valid
        Offer newOfferModel = modelMapper.map(newOffer, Offer.class);
        Model model = modelRepository.findModelByName(newOffer.getModel());
        User seller = userRepository.findUserByUsername(newOffer.getSeller());
        newOfferModel.setModel(model);
        newOfferModel.setSeller(seller);
        newOfferModel.setTransmissionType(TransmissionTypeEnum.valueOf(newOffer.getTransmissionType().toUpperCase()));
        newOfferModel.setEngineType(EngineTypeEnum.valueOf(newOffer.getEngineType().toUpperCase()));
        offerRepository.saveAndFlush(newOfferModel);
    }

    @Override
    public List<OffersDemoViewModel> getAllOffersByModel(String modelName) {
        List<OffersDemoViewModel> allOffersByModel = offerRepository.findAllByModelName(modelName)
                .stream()
                .map(offer -> modelMapper.map(offer, OffersDemoViewModel.class))
                .toList();
        return allOffersByModel;
    }
}