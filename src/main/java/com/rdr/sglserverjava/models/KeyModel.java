package com.rdr.sglserverjava.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//classe com as chaves primarias
public class KeyModel implements Serializable {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(nullable = false)
    private UUID id;

    //@Column(nullable = false)
    private int tenantId;
   
}
