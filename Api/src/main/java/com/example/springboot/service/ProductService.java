package com.example.springboot.service;

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

public ResponseEntity<List<ProductModel>> getAllProducts() {
    List<ProductModel> productsList = productRepository.findAll();
    if(productsList.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productsList);
     } else {
           for(ProductModel product : productsList) {
            Integer id = product.getidProduct();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }
}
                              /*FOR*/

//productList é gerada e populada a partir de uma coleção de objetos do tipo ProductModel que pode ser retornando de uma consulta ao banco de dados ou criada manualmente.
//productList é uma lista de objetos do tipo ProductModel
//em cada iteração a variavel product será uma instancia individual de um objeto ProductModel.
//product é uma instancia da classe ProductModel
//productList é uma instancia de uma lista (como List<ProductModel>), que contem várias instancias (objetos) da classe ProductModel.


                            /*METHODON */

/*Quando voce usa o "methodOn(ProductController.class)", voce esta passando ProductController.class diretamente para o methodOn(). Isso faz com que o methodOn() utilize a reflexão para "criar" a instancia virtual do controlador e chamar o método desejado sem a necessidade de voce instancia-lo manualmente. */

/*Aqui:
 * methodOn(ProductController.class) é a classe do controlador.
 
 * methodOn(ProductController.class) usa essa classe para simular a criação de um objeto do controlador.
 
 * o método "getOneProduct(id)" será chamado virtualmente (não precisa instanciar um objeto de ProductController explicitamente).
 */ 


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

}