package com.example.springboot.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;




@Entity
@Table(name = "tb_categorias")
public class CategoriaModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable = false, unique = true)
    private String nome;

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;

    }

    public String getNome() {
        return nome;

    }

    public void setNome (String nome) {
        this.nome = nome;
    }
}
