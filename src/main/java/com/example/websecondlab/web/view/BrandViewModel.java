package com.example.websecondlab.web.view;

public class BrandViewModel {

    private String name;

    public BrandViewModel(String name) {
        this.name = name;
    }

    public BrandViewModel() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                '}';
    }
}