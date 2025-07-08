package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.models.ItemCarrinhoModel;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinhoModel, Long> {}
