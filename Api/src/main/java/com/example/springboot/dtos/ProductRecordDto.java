package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;





public record ProductRecordDto(@NotBlank String name, @NotBlank String caracteristicas, @NotNull Long idCategoria) {
}
