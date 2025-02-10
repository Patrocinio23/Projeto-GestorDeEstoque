package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;





public record ProductRecordDto(@NotBlank String name, @NotBlank String caracteristicas) {
}
