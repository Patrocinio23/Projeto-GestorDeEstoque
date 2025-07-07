package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.CategoriaModel;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.CategoriaRepository;
import com.example.springboot.repositories.ProductRepository;

@Service
public class ProductService {

@Autowired
ProductRepository productRepository;
CategoriaRepository categoriaRepository;


public List<ProductModel> getAllProducts() {
    List<ProductModel> productList = productRepository.findAll();
    return(productList);
        
}
                              /*FOR*/

//productList é gerada e populada a partir de uma coleção de objetos do tipo ProductModel que pode ser retornando de uma consulta ao banco de dados ou criada manualmente.
//productList é uma lista de objetos do tipo ProductModel
//product é uma instancia da classe ProductModel
//productList é uma instancia de uma lista (como List<ProductModel>), que contem várias instancias (objetos) da classe ProductModel.


                            /*METHODON */

/*Quando voce usa o "methodOn(ProductController.class)", voce esta passando ProductController.class diretamente para o methodOn(). Isso faz com que o methodOn() utilize a reflexão para "criar" a instancia virtual do controlador e chamar o método desejado sem a necessidade de voce instancia-lo manualmente. */


 /* o método "getOneProduct(id)" será chamado virtualmente (não precisa instanciar um objeto de ProductController explicitamente).
 */ 


 public ProductModel getOneProduct(Integer id) {
    Optional<ProductModel> product = productRepository.findById(id);
    if (product.isPresent()) {
      return product.get(); 
    }
    
   return null;
   
}

  public ProductModel saveProduct(ProductRecordDto productRecordDto) {
        ProductModel productModel= new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);

        // Aqui você trata o campo que o BeanUtils não entende
        CategoriaModel categoria = categoriaRepository.findById(productRecordDto.idCategoria())
       .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

       productModel.setCategoria(categoria);


        return productRepository.save(productModel);
  
  }

 public void deleteProduct(Integer id) {
    Optional<ProductModel> product = productRepository.findById(id);
    if(product.isPresent()){
       productRepository.delete(product.get());
    }
  
}

public ProductModel updateProduct(Integer id, ProductRecordDto productRecordDto){
  Optional<ProductModel> product = productRepository.findById(id);
  if(product.isPresent()){
    ProductModel productModel = product.get();

    BeanUtils.copyProperties(productRecordDto, productModel);
    productRepository.save(productModel);

    return productModel;
  } else {
    throw new RuntimeException("Product not found");
  }
 
}

} 
/*Entenda!! voce precisa prestar mais atenção nas classes que estão sendo utilizadas, 
e se ligar no que elas retornam, e quais métodos estão diponiveis nelas para
utilizar*/