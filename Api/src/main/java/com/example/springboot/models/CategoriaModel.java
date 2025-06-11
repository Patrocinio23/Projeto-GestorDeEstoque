package com.example.springboot.models;

import java.io.Serializable;
import jakarta.persistence.*;




@Entity
@Table(name = "tb_categorias")
public class CategoriaModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

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
