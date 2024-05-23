package com.rdr.sglserverjava.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {   

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDatabaseViolation(DataIntegrityViolationException ex) {

        String error = "Campos repetidos: ";
        
        Pattern regex = Pattern.compile("(?:Chave|Key|chave|key).+?\\((.+)?\\)=");
        Matcher matcher = regex.matcher(ex.getMessage()); 
        if (matcher.find()) {
            //var campos = matcher.group(1).split(",");
            var campos = matcher.group(1);
            campos = campos.replaceAll("tenantId,", "");
            error+=campos;
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}