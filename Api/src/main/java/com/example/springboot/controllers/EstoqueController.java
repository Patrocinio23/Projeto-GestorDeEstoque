package com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.EstoqueRecordDto;
import com.example.springboot.models.EstoqueModel;
import com.example.springboot.service.EstoqueService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;
    
    

    @PostMapping
public ResponseEntity<EstoqueModel> saveEstoque(@RequestBody @Valid EstoqueRecordDto estoqueRecordDto) {
    EstoqueModel estoque = estoqueService.saveEstoque(estoqueRecordDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
}

	
    
                
    @PutMapping("/{acao}")
    public ResponseEntity<EstoqueModel> updateEstoque(@PathVariable String acao, @RequestBody @Valid EstoqueRecordDto estoqueRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.saveEstoque(estoqueRecordDto));

    }
        
           
  
  
     @GetMapping
    public ResponseEntity<List<EstoqueModel>> getAllEstoque() {
        List<EstoqueModel> estoqueList = estoqueService.getAllEstoque();
        return ResponseEntity.ok(estoqueList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> getEstoqueById(@PathVariable Long id) { 
        return ResponseEntity.ok(estoqueService.getEstoqueById(id));
    } 

    @DeleteMapping("{id}")
    public ResponseEntity<EstoqueModel> deleteEstoque(@PathVariable Long id) {
      return ResponseEntity.ok(estoqueService.deleteEstoque(id));

    }
}


 
 
  
