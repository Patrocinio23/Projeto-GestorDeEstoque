/*package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import com.example.springboot.services.TwilioService.TwilioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
        
        @Autowired
        private TwilioService twilioService;
        
	
	@GetMapping("/products")
	//Essas anotações permitem que voce associe URLs específicas com métodos de manipulação HTTP no seu controlador, tornando a construção de APIs web mais simples.
	//uma anotação @ é simplesmente uma marca que voce coloca em cima de uma classe, método, campo, etc. Elas podem ser interpretadas por ferramentas, framework ou bibliotecas que usam essas informações.
	public ResponseEntity<List<ProductModel>> getAllProducts(){
		List<ProductModel> productsList = productRepository.findAll();
		//essa lista foi declarada para aceitar apenas objetos do tipo ProductModel ou de suas subclasses.
		//os sinais <> são usados para classes Genéricas, onde o tipo de dado é definido no momento do instanciamento.
		if(!productsList.isEmpty()) {
			//productList é gerada e populada a partir de uma coleção de objetos do tipo ProductModel, que pode ser retornado de uma cosulta ao banco de dados ou criada manualmente
			for(ProductModel product : productsList) {
				//em cada iteração a variavel product será uma instancia individual de um objeto ProductModel.
				//product é uma instancia da classe ProductModel
				//productList é uma instancia de uma lista (como List<ProductModel>), que contem várias instancias (objetos) da classe ProductModel.
				Integer id = product.getidProduct();
				product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
				//HATEOS é uma forma de enriquecer as respostas da API com links que indicam o que o cliente pode fazer a seguir, facilitando a interação sem precisar saber os detalhes das rotas.
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(productsList);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable Integer id){
		Optional<ProductModel> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
                        
		}
                product.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
		return ResponseEntity.status(HttpStatus.OK).body(product.get());
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productRecordDto, productModel);
                
               /*  Envia o SMS após o produto ser salvo
                String messageContent = "Produto novo: " + productModel.getName() + // Personalize a mensagem com o nome do produto
                                        "Caracteristicas: " + productModel.getCaracteristicas();
                twilioService.sendSms(messageContent);
		
                
                return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
		Optional<ProductModel> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productRepository.delete(product.get());
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRecordDto productRecordDto) {
		Optional<ProductModel> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		var productModel = productO.get();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
	}

    
}*/
