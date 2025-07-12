package com.example.springboot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carrinho")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean finalizado = false;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemCarrinhoModel> itens;

    // Getters e Setters

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public List<ItemCarrinhoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoModel> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }
}


