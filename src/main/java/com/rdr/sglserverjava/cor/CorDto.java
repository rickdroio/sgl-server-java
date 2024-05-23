package com.rdr.sglserverjava.cor;

import jakarta.validation.constraints.NotBlank;

public record CorDto(Long id, @NotBlank String nome, @NotBlank String sigla, String rgb) {
    
}
