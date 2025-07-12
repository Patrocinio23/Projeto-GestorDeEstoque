package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


 @Entity
 @Table(name = "tb_item_carrinho")
 public class ItemCarrinhoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProductModel produto;

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    @JsonBackReference
    private CarrinhoModel carrinho;

    // Getters e Setters

    public ProductModel getProduto() {
        return produto;
    }

    public void setProduto(ProductModel produto) {
        this.produto = produto;
    }

    public CarrinhoModel getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoModel carrinho) {
        this.carrinho = carrinho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

   
}

