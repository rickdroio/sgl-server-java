package com.rdr.sglserverjava.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(Long tenantId, @NotBlank String nome, @NotBlank String email, @NotBlank String password) {
    
}
