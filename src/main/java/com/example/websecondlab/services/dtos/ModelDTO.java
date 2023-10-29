package com.example.websecondlab.services.dtos;

import com.example.websecondlab.consts.enums.CategoryEnum;

public class ModelDTO {

    private long id;
    private String name;
    private CategoryEnum category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private BrandDTO brand;


    public ModelDTO(String name, CategoryEnum category, String imageUrl, int startYear, int endYear, BrandDTO brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public ModelDTO() {}


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public BrandDTO getBrand() {
        return brand;
    }
    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ModelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand.getName() +
                '}';
    }
}