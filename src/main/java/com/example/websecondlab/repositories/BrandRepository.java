package com.example.websecondlab.repositories;

import com.example.websecondlab.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    void deleteBrandByName(String name);

}