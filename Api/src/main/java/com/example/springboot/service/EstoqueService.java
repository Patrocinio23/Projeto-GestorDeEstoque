package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dtos.EstoqueRecordDto;
import com.example.springboot.models.EstoqueModel;
import com.example.springboot.repositories.EstoqueRepository;

@Service
public class EstoqueService {

@Autowired
private EstoqueRepository estoqueRepository;

public EstoqueModel saveEstoque(EstoqueRecordDto estoqueRecordDto) {
 Optional<EstoqueModel> estoque = estoqueRepository.findById(estoqueRecordDto.idProduct());
 
 if (estoque.isPresent()) {
    throw new IllegalArgumentException("Produto já cadastrado no estoque.");
}

 EstoqueModel estoqueModel = new EstoqueModel();
 BeanUtils.copyProperties(estoqueRecordDto, estoqueModel);
 estoqueModel.setidProduct(estoqueRecordDto.idProduct()); 
 estoqueModel.setQuantidade(estoqueRecordDto.quantidade()); // 👉 Define a quantidade

 return estoqueRepository.save(estoqueModel);

  }


public EstoqueModel updateEstoque(Integer id, String acao, EstoqueRecordDto estoqueRecordDto){
Optional<EstoqueModel> estoque = estoqueRepository.findById(id);
if(estoque.isPresent()){
    EstoqueModel estoqueModel = estoque.get();

    if("-".equals(acao)){
        if(estoqueModel.getQuantidade() >= estoqueRecordDto.quantidade()){
           estoqueModel.setQuantidade(estoqueModel.getQuantidade() - estoqueRecordDto.quantidade());

        } else {
            throw new IllegalArgumentException("Quantidade insulficiente no estoque");
        }
     
    } else {
        estoqueModel.setQuantidade(estoqueModel.getQuantidade() + estoqueRecordDto.quantidade());
    } 
        estoqueRepository.save(estoqueModel);
        return(estoqueModel);
        
    } else {
        throw new IllegalArgumentException("Estoque não encontrado");
    }

}


    public List<EstoqueModel> getAllEstoque(){
        return estoqueRepository.findAll();
    }


    public EstoqueModel getEstoqueById(Integer id) {
        Optional<EstoqueModel>estoque = estoqueRepository.findById(id);

        if(estoque.isPresent()){
            return estoque.get();
        } else {
            throw new IllegalArgumentException("Produto não encontrado no estoque."); 
        }
    }

    public EstoqueModel deleteEstoque(Integer id) {
        Optional<EstoqueModel>estoque =  estoqueRepository.findById(id);

        if(estoque.isPresent()) {
           estoqueRepository.delete(estoque.get());
           return estoque.get(); 
        } else {

        }  throw new IllegalArgumentException("Produto não encontrado no estoque."); 
    }
  }

