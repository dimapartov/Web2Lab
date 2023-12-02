package com.example.websecondlab.web.view;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;

import java.math.BigDecimal;

public class OfferFullViewModel {

    private String imageUrl;
    private BigDecimal price;
    private String seller;
    private String model;
    private String brand;
    private int mileage;
    private TransmissionTypeEnum transmissionType;
    private EngineTypeEnum engineType;
    private int year;
    private String description;
    private CategoryEnum category;

    public OfferFullViewModel(String imageUrl, BigDecimal price, String seller, String model, String brand, int mileage, TransmissionTypeEnum transmissionType, EngineTypeEnum engineType, int year, String description, CategoryEnum category) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.seller = seller;
        this.model = model;
        this.brand = brand;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    public OfferFullViewModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "OfferFullViewModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", transmissionType=" + transmissionType +
                ", engineType=" + engineType +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}