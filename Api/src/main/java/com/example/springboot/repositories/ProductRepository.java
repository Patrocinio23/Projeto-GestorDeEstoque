package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.ProductModel;



@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{


}
