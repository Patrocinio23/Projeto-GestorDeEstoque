package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dtos.AddItemCarrinhoDto;
import com.example.springboot.models.CarrinhoModel;
import com.example.springboot.models.EstoqueModel;
import com.example.springboot.models.ItemCarrinhoModel;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.CarrinhoRepository;
import com.example.springboot.repositories.EstoqueRepository;
import com.example.springboot.repositories.ItemCarrinhoRepository;
import com.example.springboot.repositories.ProductRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public CarrinhoModel criarCarrinho() {
        CarrinhoModel carrinho = new CarrinhoModel();
        carrinho.setFinalizado(false);
        return carrinhoRepository.save(carrinho);
    }

    public CarrinhoModel adicionarItem(AddItemCarrinhoDto dto) {
        CarrinhoModel carrinho = carrinhoRepository.findById(dto.idCarrinho())
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        if (carrinho.getFinalizado()) throw new RuntimeException("Carrinho já finalizado");

        ProductModel produto = productRepository.findById(dto.idProduct())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        EstoqueModel estoque = estoqueRepository.findByProduct_IdProduct(dto.idProduct())
            .orElseThrow(() -> new RuntimeException("Produto não está no estoque"));

        if (dto.quantidade() > estoque.getQuantidade())
            throw new RuntimeException("Estoque insuficiente");

        ItemCarrinhoModel item = new ItemCarrinhoModel();
        item.setProduto(produto);
        item.setQuantidade(dto.quantidade());
        item.setCarrinho(carrinho);

        itemCarrinhoRepository.save(item);

        return carrinhoRepository.findById(carrinho.getId()).get();
    }

    public CarrinhoModel finalizarCompra(Long idCarrinho) {
        CarrinhoModel carrinho = carrinhoRepository.findById(idCarrinho)
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        for (ItemCarrinhoModel item : carrinho.getItens()) {
            EstoqueModel estoque = estoqueRepository.findByProduct_IdProduct(item.getProduto().getIdProduct())
                .orElseThrow(() -> new RuntimeException("Produto sem estoque"));

            if (estoque.getQuantidade() < item.getQuantidade())
                throw new RuntimeException("Estoque insuficiente para produto: " + item.getProduto().getName());

            estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
            estoqueRepository.save(estoque);
        }

        carrinho.setFinalizado(true);
        return carrinhoRepository.save(carrinho);
    }
}
