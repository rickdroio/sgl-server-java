package com.rdr.sglserverjava.cidade;

import com.rdr.sglserverjava.shared.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "cidades", uniqueConstraints = { @UniqueConstraint(columnNames = {"tenantId", "nome", "ibge"})})
//@IdClass(KeyModel.class)
public class Cidade extends BaseModel {

/*     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    private Long tenantId; */

    //private String nome;
    private String uf;
    private String ibge;
    
/*     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTenantId() {
        return tenantId;
    }
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    } */


/*     public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } */
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
