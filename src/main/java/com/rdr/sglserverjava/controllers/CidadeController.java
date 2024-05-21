package com.rdr.sglserverjava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rdr.sglserverjava.dtos.CidadeDto;
import com.rdr.sglserverjava.models.Cidade;
import com.rdr.sglserverjava.services.CidadeService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

    CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }
    
    @PostMapping()
    public ResponseEntity<Cidade> create(@RequestBody @Valid CidadeDto cidadeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.create(cidadeDto));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Cidade>> saveBatch(@RequestBody List<CidadeDto> cidadesDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.saveBatch(cidadesDto));
    }    

/*     @GetMapping()
    public ResponseEntity<List<CidadeModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
    }
 */    

    @GetMapping()
    public ResponseEntity<Page<Cidade>> getAllPagination(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int pageSize) {
        var items = cidadeService.findAllPagination(offset, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        var item = cidadeService.findById(id);
        if (item != null)
            return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findById(id));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
}
