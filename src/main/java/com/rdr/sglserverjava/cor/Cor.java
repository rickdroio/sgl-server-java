package com.rdr.sglserverjava.cor;

import com.rdr.sglserverjava.shared.BaseModel;
import com.rdr.sglserverjava.shared.KeyModel;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "cores", uniqueConstraints = { @UniqueConstraint(columnNames = {"tenantId", "sigla"})})
@IdClass(KeyModel.class)
public class Cor extends BaseModel {
    
    private String sigla;
    private String rgb;

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getRgb() {
        return rgb;
    }
    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
    
}
