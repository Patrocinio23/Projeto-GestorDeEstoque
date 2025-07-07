package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.dtos.CategoriaRecordDto;
import com.example.springboot.models.CategoriaModel;
import com.example.springboot.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //1. Criar Categoria
    public CategoriaModel saveCategoria(CategoriaRecordDto categoriaRecordDto) {
       CategoriaModel categoriaModel = new CategoriaModel();
       categoriaModel.setName(categoriaRecordDto.name());
       return categoriaRepository.save(categoriaModel); 
    }

    //2. Listar todas as Categorias
    public List<CategoriaModel> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    //3. Listar Categoria por id
    public CategoriaModel getCategoriaById(Integer id){
        return categoriaRepository.findById(id) 
          .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com o ID: " + id));
    
    }

    //4. deletar categoria usando id
    public void deleteCategoria(Integer id){
        CategoriaModel categoria = getCategoriaById(id);
        categoriaRepository.delete(categoria);
    }

    

    
}
