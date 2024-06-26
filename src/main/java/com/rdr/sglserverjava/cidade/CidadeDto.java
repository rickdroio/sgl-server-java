package com.rdr.sglserverjava.cidade;

import jakarta.validation.constraints.NotBlank;

public record CidadeDto(Long id, @NotBlank String nome, @NotBlank String uf, @NotBlank String ibge) {
    
}
