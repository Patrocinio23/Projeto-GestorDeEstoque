package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.models.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
    
}