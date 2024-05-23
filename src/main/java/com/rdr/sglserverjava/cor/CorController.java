package com.rdr.sglserverjava.cor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cores")
public class CorController {

    private CorService corService;

    public CorController(CorService corService) {
        this.corService = corService;
    }
    
    @GetMapping()
    public ResponseEntity<Cor> teste() {
        var item = corService.findById(Long.valueOf(1));
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }   
    
}
