package com.example.websecondlab.repositories;

import com.example.websecondlab.models.Model;
import com.example.websecondlab.consts.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByCategory(CategoryEnum category);
    List<Model> findAllByBrandName(String brandName);
}