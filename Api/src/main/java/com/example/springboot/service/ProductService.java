package com.example.springboot.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot.controllers.ProductController;
import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;


@Service
public class ProductService {

@Autowired
ProductRepository productRepository;


/*public ResponseEntity<List<ProductModel>> getAllProducts() {

    try{
    List<ProductModel> productList = productRepository.findAll();
    if(productList.isEmpty()) {
        throw new ProductNotFoundException("Lista de Produtos não encontrada");
     } else {
           for(ProductModel product : productList) {
            Integer id = product.getidProduct();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
        }
        return();
    }
    } catch (Exception e) {
        throw new RuntimeException("Erro ao buscar a lista de produtos: " + e.getMessage());
    
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


 /*public Object getOneProduct(Integer id) {
    try {
    Optional<ProductModel> product = productRepository.findById(id);
    if (product.isPresent()) {
        return product.get();
    } else {
        throw new ProductNotFoundException("Produto não encontrado");
    }
 } catch(Exception e){
    throw new RuntimeException("Erro ao buscar o produto: " + e.getMessage());
 }
   
  }*/



  public ProductModel saveProduct(ProductRecordDto productRecordDto) {
        ProductModel productModel= new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
  
  }

} 