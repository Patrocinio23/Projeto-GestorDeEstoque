package com.example.springboot.controllers;

import com.example.springboot.dtos.EstoqueRecordDto;
import com.example.springboot.models.EstoqueModel;

import com.example.springboot.repositories.EstoqueRepository;

import jakarta.validation.Valid;
import java.util.List;


import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;
    
    

    @PostMapping("/{acao}")
    public ResponseEntity<EstoqueModel> saveEstoque(@PathVariable String acao, @RequestBody @Valid EstoqueRecordDto estoqueRecordDto) {
                
        Optional<EstoqueModel> estoque = estoqueRepository.findById(estoqueRecordDto.idProduct());
        
        // Converte o DTO em EstoqueModel
        var estoqueModel = new EstoqueModel();
        
	if(estoque.isEmpty()) {
            
            // Copia as propriedades do DTO para o Model
            BeanUtils.copyProperties(estoqueRecordDto, estoqueModel);
		
                 
           // Salva no banco de dados
            return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoqueModel));
                        
	}else{
         estoqueModel = estoque.get();
        
        }
        if("-".equals(acao)){
              estoqueModel.setQuantidade(estoque.get().getQuantidade() - estoqueRecordDto.quantidade()) ;
            
            }else{
            estoqueModel.setQuantidade(estoque.get().getQuantidade() + estoqueRecordDto.quantidade()) ;
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoqueModel));
        }
           
   @GetMapping("")
    public ResponseEntity<List<Object[]>> getProductDetailsByProductId(@RequestParam(required = false) Long idProduct) {
        List<Object[]> result = estoqueRepository.findProductDetailsByProductId(idProduct);
          return ResponseEntity.ok(result);
    
    }
}   
 
  
