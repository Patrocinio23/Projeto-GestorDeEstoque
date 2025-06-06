package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.dtos.CategoriaRecordDto;
import com.example.springboot.models.CategoriaModel;
import com.example.springboot.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //1. Criar Categoria

    @PostMapping
    public CategoriaModel saveCategoria(CategoriaRecordDto categoriaRecordDto) {
       CategoriaModel categoriaModel = new CategoriaModel();
       categoriaModel.setNome(categoriaRecordDto.nome());
       return categoriaRepository.save(categoriaModel); 
    }

    @GetMapping
    public List<CategoriaModel> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}") 
    public CategoriaModel getCategoriaById(Integer id){
        return categoriaRepository.findById(id) 
          .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com o ID: " + id));
    
    }

    @DeleteMapping
    public void deleteCategoria(Integer id){
        CategoriaModel categoria = getCategoriaById(id);
        categoriaRepository.delete(categoria);
    }

    

    
}
