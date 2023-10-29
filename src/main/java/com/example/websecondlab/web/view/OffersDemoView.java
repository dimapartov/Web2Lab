package com.example.websecondlab.web.view;

import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.services.dtos.UserDTO;

import java.math.BigDecimal;

public class OffersDemoView {

    private String description;
    private String imageUrl;
    private BigDecimal price;
    private String seller;
    private String model;
    private String brand;

    public OffersDemoView() {
    }

    public String getDescription() {
        return description;
    }
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


    public void setDescription(String description) {
        this.description = description;
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
        return "OffersDemoView{" +
                "description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}