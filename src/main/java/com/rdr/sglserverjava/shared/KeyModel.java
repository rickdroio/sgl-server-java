package com.rdr.sglserverjava.shared;

import java.io.Serializable;

//classe com as chaves primarias
public class KeyModel implements Serializable {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(nullable = false)
    private Long id;

    //@Column(nullable = false)
    private Long tenantId;
   
}
