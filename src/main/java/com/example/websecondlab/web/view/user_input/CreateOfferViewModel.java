package com.example.websecondlab.web.view.user_input;

public class CreateOfferViewModel {

    private String seller;
    private String brandName;
    private String modelName;
    private int year;
    private int price;
    private int mileage;
    private String transmissionType;
    private String engineType;
    private String description;


    public CreateOfferViewModel(String seller, String brandName, String modelName, int year, int price, int mileage, String transmissionType, String engineType, String description) {
        this.seller = seller;
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.description = description;
    }
    public CreateOfferViewModel() {
    }


    public String getSeller() {
        return seller;
    }
    public String getBrandName() {
        return brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public int getYear() {
        return year;
    }
    public int getPrice() {
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


    public void setSeller(String seller) {
        this.seller = seller;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}