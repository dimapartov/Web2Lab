package com.example.websecondlab.repositories;

import java.util.List;

import com.example.websecondlab.web.view.ModelByBrandViewModel;
import com.example.websecondlab.web.view.OfferFullViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByCategory(CategoryEnum category);
    List<Model> findAllByBrandName(String brandName);
    Model findModelByName(String modelName);


    @Query(value = "SELECT new com.example.websecondlab.web.view.ModelByBrandViewModel(m.brand.name, m.name, m.category, m.startYear, m.endYear) FROM Model m JOIN Brand b ON m.brand.id=b.id WHERE b.name=:brand")
    List<ModelByBrandViewModel> findAllModelsByBrandName(@Param(value = "brand") String brand);
}