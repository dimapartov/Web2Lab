package com.example.websecondlab.repositories;

import java.math.BigDecimal;
import java.util.List;

import com.example.websecondlab.web.view.OfferFullViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    List<Offer> findAllByModelName(String modelName);

    @Query(value = "SELECT new com.example.websecondlab.web.view.OfferFullViewModel" +
            "(" +
            "o.imageUrl," +
            "o.price," +
            "o.seller.username," +
            "o.model.name," +
            "m.brand.name," +
            "o.mileage," +
            "o.transmissionType," +
            "o.engineType," +
            "o.year," +
            "o.description," +
            "m.category" +
            ") " +
            "FROM Offer o " +
            "JOIN o.model m " +
            "JOIN o.seller u " +
            "JOIN Brand b " +
            "ON m.brand.id=b.id " +
            "WHERE o.id=:id")
    OfferFullViewModel getOfferFullInfo(@Param(value = "id") long id);
}