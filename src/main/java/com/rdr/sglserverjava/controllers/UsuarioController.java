package com.rdr.sglserverjava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rdr.sglserverjava.dtos.UsuarioDto;
import com.rdr.sglserverjava.models.UsuarioModel;
import com.rdr.sglserverjava.services.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @PostMapping()
    public ResponseEntity<UsuarioModel> save(@RequestBody @Valid UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.newUser(usuarioDto));
    }
    
}
