package com.example.websecondlab.models.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ImageUrlBaseEntity extends CreatedModifiedBaseEntity {

    protected String imageUrl;


    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}