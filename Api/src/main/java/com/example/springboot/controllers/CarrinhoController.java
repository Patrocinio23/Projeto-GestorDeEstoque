package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.AddItemCarrinhoDto;
import com.example.springboot.models.CarrinhoModel;
import com.example.springboot.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/criar")
    public ResponseEntity<CarrinhoModel> criar() {
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.criarCarrinho());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<CarrinhoModel> adicionar(@RequestBody AddItemCarrinhoDto dto) {
        return ResponseEntity.ok(carrinhoService.adicionarItem(dto));
    }

    @PostMapping("/finalizar/{id}")
    public ResponseEntity<CarrinhoModel> finalizar(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.finalizarCompra(id));
    }
}

