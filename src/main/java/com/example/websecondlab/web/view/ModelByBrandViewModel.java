package com.example.websecondlab.web.view;

public class ModelByBrandViewModel {

    private String brand;
    private String name;
    private String category;
    private int startYear;
    private int endYear;

    public ModelByBrandViewModel(String brand, String name, String category, int startYear, int endYear) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public ModelByBrandViewModel() {
    }

    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public int getStartYear() {
        return startYear;
    }
    public int getEndYear() {
        return endYear;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }


    @Override
    public String toString() {
        return "ModelByBrandViewModel{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}