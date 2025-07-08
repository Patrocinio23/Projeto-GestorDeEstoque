package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.models.CarrinhoModel;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {}
