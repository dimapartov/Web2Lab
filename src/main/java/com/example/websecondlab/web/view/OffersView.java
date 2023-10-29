package com.example.websecondlab.web.view;

import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.services.dtos.UserDTO;

import java.math.BigDecimal;

public class OffersView {

    private String description;
    private String imageUrl;
    private BigDecimal price;
    private UserDTO seller;
    private ModelDTO model;

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UserDTO getSeller() {
        return seller;
    }

    public ModelDTO getModel() {
        return model;
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

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "OffersView{" +
                "description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", seller=" + seller.getUsername() +
                ", model=" + model.getName() +
                ", brand=" + model.getBrand().getName() +
                '}';
    }
}