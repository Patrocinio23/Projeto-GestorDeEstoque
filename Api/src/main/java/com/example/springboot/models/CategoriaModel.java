package com.example.springboot.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name = "tb_categorias")
public class CategoriaModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "categoria")
    private List<ProductModel> produtos;
    public Long getId() {
        return id; 
    }
    
    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;

    }

    public void setName (String name) {
        this.name = name;
    }
}
