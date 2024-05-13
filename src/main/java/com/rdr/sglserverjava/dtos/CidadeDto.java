package com.rdr.sglserverjava.dtos;

import jakarta.validation.constraints.NotBlank;

public record CidadeDto(@NotBlank String nome, @NotBlank String uf, @NotBlank String ibge) {
    
}
