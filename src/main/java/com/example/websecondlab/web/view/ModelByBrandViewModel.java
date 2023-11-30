package com.example.websecondlab.web.view;

public class ModelByBrandViewModel {

    private String brandName;
    private String modelName;
    private String category;
    private int startYear;
    private int endYear;

    public String getBrandName() {
        return brandName;
    }
    public String getModelName() {
        return modelName;
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

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
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
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", category='" + category + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}