package com.example.websecondlab.services.dtos;

import java.math.BigDecimal;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;

public class OfferDTO {

    private long id;
    private String description;
    private String imageUrl;
    private int year;
    private int mileage;
    private BigDecimal price;
    private TransmissionTypeEnum transmissionType;
    private EngineTypeEnum engineType;
    private UserDTO seller;
    private ModelDTO model;



    public OfferDTO(String description, String imageUrl, int year, int mileage, BigDecimal price,
                    TransmissionTypeEnum transmissionType, EngineTypeEnum engineType, UserDTO seller, ModelDTO model) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.seller = seller;
        this.model = model;
    }

    public OfferDTO() {}


    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }
    public void setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
    }

    public EngineTypeEnum getEngineType() {
        return engineType;
    }
    public void setEngineType(EngineTypeEnum engineType) {
        this.engineType = engineType;
    }

    public UserDTO getSeller() {
        return seller;
    }
    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public ModelDTO getModel() {
        return model;
    }
    public void setModel(ModelDTO model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "OfferDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmissionType=" + transmissionType +
                ", engineType=" + engineType +
                ", seller=" + seller.getUsername() +
                ", model=" + model.getName() +
                ", brand="+ model.getBrand().getName() +
                ", category=" + model.getCategory() +
                ", url='" + model.getImageUrl() +
                '}';
    }
}