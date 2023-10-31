package com.example.websecondlab.web.view.user_input;

import java.math.BigDecimal;

public class CreateOfferViewModel {

    private String seller;
    private String brand;
    private String model;
    private int year;
    private BigDecimal price;
    private int mileage;
    private String transmissionType;
    private String engineType;
    private String description;


    public CreateOfferViewModel(String seller,
                                String brand,
                                String model,
                                int year, BigDecimal price,
                                int mileage,
                                String transmissionType,
                                String engineType) {
        this.seller = seller;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeller() {
        return seller;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDescription() {
        return description;
    }
}