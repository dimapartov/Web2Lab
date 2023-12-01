package com.example.websecondlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    void deleteBrandByName(String name);

}