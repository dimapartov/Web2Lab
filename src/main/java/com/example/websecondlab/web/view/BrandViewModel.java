package com.example.websecondlab.web.view;

public class BrandViewModel {

    private String brandName;


    public String getBrandName() {
        return brandName;
    }


    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    @Override
    public String toString() {
        return "BrandViewModel{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}