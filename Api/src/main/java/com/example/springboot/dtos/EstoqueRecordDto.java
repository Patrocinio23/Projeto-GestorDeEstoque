
package com.example.springboot.dtos;



import jakarta.validation.constraints.NotNull;



public record EstoqueRecordDto(@NotNull Integer quantidade, @NotNull Integer idProduct, Integer idEstoque) {

 
	
}


