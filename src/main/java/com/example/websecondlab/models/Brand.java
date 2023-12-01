package com.example.websecondlab.models;

import java.util.Set;

import com.example.websecondlab.models.base.CreatedModifiedBaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand extends CreatedModifiedBaseEntity {

    private String name;
    private Set<Model> models;


    protected Brand() {}


    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    public Set<Model> getModels() {
        return models;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}