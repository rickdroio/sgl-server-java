package com.rdr.sglserverjava.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cidades")
public class CidadeModel implements Serializable{
    private static final long serialVersionOnUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCidade;
    private String nome;
    private String uf;
    private String ibge;

    public static long getSerialversiononuid() {
        return serialVersionOnUID;
    }    
    public UUID getIdCidade() {
        return idCidade;
    }
    public void setIdCidade(UUID idCidade) {
        this.idCidade = idCidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getIbge() {
        return ibge;
    }
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
    
}
