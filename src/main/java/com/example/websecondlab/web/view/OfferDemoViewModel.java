package com.example.websecondlab.web.view;

import java.math.BigDecimal;

public class OfferDemoViewModel {

    private long id;
    private String imageUrl;
    private BigDecimal price;
    private String seller;
    private String model;
    private String brand;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OfferDemoViewModel{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}