package com.example.websecondlab.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.models.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByMileageLessThan(int mileage);
    List<Offer> findAllByPriceLessThan(BigDecimal price);
    List<Offer> findAllByEngineType(EngineTypeEnum engineType);
    List<Offer> findAllByTransmissionType(TransmissionTypeEnum transmissionType);
    List<Offer> findAllBySellerUsername(String username);

}