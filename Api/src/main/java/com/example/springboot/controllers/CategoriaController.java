package com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.CategoriaRecordDto;
import com.example.springboot.models.CategoriaModel;
import com.example.springboot.service.CategoriaService;


/*A controller é a entrada da requisição(HTTP)-> É aqui
que definimos as rotas.*/

@RestController
@RequestMapping("/categoria") 
public class CategoriaController {

/*toda lógica deve estar na SERVICE, nunca na controller.
 Então a controller vai chamar a service pra resolver a requisição.
 */

@Autowired
private CategoriaService categoriaService;

@PostMapping
public ResponseEntity<CategoriaModel> saveCategoria(@RequestBody CategoriaRecordDto categoriaRecordDto) {
    CategoriaModel newCategoria = categoriaService.saveCategoria(categoriaRecordDto);
    return ResponseEntity.ok(newCategoria); 
}

@GetMapping
public ResponseEntity<List<CategoriaModel>> getAllCategoria() {
    return ResponseEntity.ok(categoriaService.getAllCategoria());
}
    

@GetMapping("/{id}")
public ResponseEntity<CategoriaModel> getCategoriaById(@PathVariable Integer id) {
    return ResponseEntity.ok(categoriaService.getCategoriaById(id));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCategoria(@PathVariable Integer id) {
    categoriaService.deleteCategoria(id);
    return ResponseEntity.ok("Categoria deletada com sucesso");

}

}
