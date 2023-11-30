package com.example.websecondlab.web.view;

public class ModelByBrandViewModel {

    private String brandName;
    private String modelName;
    private String category;
    private int startYear;
    private int endYear;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "ModelByBrandViewModel{" +
                "modelName='" + modelName + '\'' +
                ", category='" + category + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}