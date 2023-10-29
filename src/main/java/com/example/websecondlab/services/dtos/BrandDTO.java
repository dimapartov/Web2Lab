package com.example.websecondlab.services.dtos;

public class BrandDTO {

    private long id;
    private String name;


    public BrandDTO(String name) {
        this.name = name;
    }

    public BrandDTO() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}