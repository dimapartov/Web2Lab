package com.example.websecondlab.web.view;

import java.math.BigDecimal;

public class OffersDemoViewModel {

    private String imageUrl;
    private BigDecimal price;
    private String seller;
    private String model;
    private String brand;

    public OffersDemoViewModel() {}

    public String getImageUrl() {
        return imageUrl;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getSeller() {
        return seller;
    }
    public String getModel() {
        return model;
    }
    public String getBrand() {
        return brand;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "OffersDemoViewModel{" +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}