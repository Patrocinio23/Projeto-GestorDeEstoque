package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRecordDto (@NotBlank String nome) {

}


/*
* é uma classe usada para transportar dados entre camadas 
* serve para separar o que chega na API do que vai para o banco
* NÃO é uma entidade, não se conecta diretamente ao banco */  


/*POR QUE USAMOS record e não class?
 * record cria uma classe imutável de forma mais simples e reduzida.
 * já vem com construtor, toString(), equals(), e hashcode()
 * ideal para classes que só carregam dados(exatamente o caso dos DTOs).
 */


 /*POR QUE não colocamos validação para o ID no DTO?
  * é simples, é porque o ID não cem do cliente. o ID é gerado automaticamente pelo banco 

  */