package com.example.websecondlab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByCategory(CategoryEnum category);
    List<Model> findAllByBrandName(String brandName);
    Model findModelByName(String modelName);
}