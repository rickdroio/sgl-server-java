package com.rdr.sglserverjava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rdr.sglserverjava.dtos.CidadeDto;
import com.rdr.sglserverjava.models.CidadeModel;
import com.rdr.sglserverjava.services.CidadeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

    CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }
    
    @PostMapping()
    public ResponseEntity<CidadeModel> save(@RequestBody @Valid CidadeDto cidadeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(cidadeDto));
    }

    @GetMapping()
    public ResponseEntity<List<CidadeModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
    }
    
}
