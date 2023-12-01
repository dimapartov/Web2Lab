package com.example.websecondlab.models;

import java.math.BigDecimal;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.models.base.ImageUrlBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends ImageUrlBaseEntity {

    private String description;
    private int year;
    private int mileage;
    private BigDecimal price;
    private TransmissionTypeEnum transmissionType;
    private EngineTypeEnum engineType;
    private User seller;
    private Model model;


    protected Offer() {}


    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Enumerated
    @Column(name = "transmission_type")
    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

    @Enumerated
    @Column(name = "engine_type")
    public EngineTypeEnum getEngineType() {
        return engineType;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    public User getSeller() {
        return seller;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModel() {
        return model;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setEngineType(EngineTypeEnum engineType) {
        this.engineType = engineType;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}