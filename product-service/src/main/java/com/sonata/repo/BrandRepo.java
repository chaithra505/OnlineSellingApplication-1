package com.sonata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonata.model.Brand;


@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {

	Brand findByBrandName(String brandName);


}
