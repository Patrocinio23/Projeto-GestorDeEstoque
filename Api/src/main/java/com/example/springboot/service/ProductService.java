/*package com.example.springboot.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.springboot.controllers.ProductController;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;

@Service
public class ProductService {

@Autowired
ProductRepository productRepository;

public List<ProductModel> getAllProducts() {
    List<ProductModel> productsList = productRepository.findAll();
    if(!productsList.isEmpty()) {
        for(ProductModel product : productsList) {
            Integer id = product.getidProduct();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
        }
    }
    return(productsList);
}


/*Quando voce usa o "methodOn(ProductController.class)", voce esta passando ProductController.class diretamente para o methodOn(). Isso faz com que o methodOn() utilize a reflexão para "criar" a instancia virtual do controlador e chamar o método desejado sem a necessidade de voce instancia-lo manualmente. */

/*Aqui:
 * methodOn(ProductController.class) é a classe do controlador.
 
 * methodOn(ProductController.class) usa essa classe para simular a criação de um objeto do controlador.
 
 * o método "getOneProduct(id)" será chamado virtualmente (não precisa instanciar um objeto de ProductController explicitamente).
 

 public ResponseEntity<Object> getOneProduct(Integer id) {
    Optional<ProductModel> product = productRepository.findById(id);
    if(product.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        
    }
    product.get().add(linkTo(methodOn
    (ProductController.class).getAllProducts()).
    withRel("Products List"));
    return ResponseEntity.status(HttpStatus.OK).body(product.get());
  }

}*/