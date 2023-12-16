package com.example.websecondlab.repositories;

import com.example.websecondlab.web.view.BrandViewModel;
import com.example.websecondlab.web.view.OfferFullViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.models.Brand;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    void deleteBrandByName(String name);


    @Query(value = "SELECT new com.example.websecondlab.web.view.BrandViewModel(b.name) FROM Brand b")
    List<BrandViewModel> getAllBrands();
}