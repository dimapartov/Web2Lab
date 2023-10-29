package com.example.websecondlab.models;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.models.base.ImageUrlBaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends ImageUrlBaseEntity {

    private String name;
    private int startYear;
    private int endYear;
    private CategoryEnum category;
    private Brand brand;
    private Set<Offer> offers;


    protected Model() {}


    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "start_year", nullable = false)
    public int getStartYear() {
        return startYear;
    }

    @Column(name = "end_year", nullable = false)
    public int getEndYear() {
        return endYear;
    }

    @Enumerated
    @Column(name = "category", nullable = false)
    public CategoryEnum getCategory() {
        return category;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    public Brand getBrand() {
        return brand;
    }

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    public Set<Offer> getOffers() {
        return offers;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}