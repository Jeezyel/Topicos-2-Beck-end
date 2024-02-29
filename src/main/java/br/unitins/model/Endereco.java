package br.unitins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.awt.*;
@Entity
public class Endereco extends DefaultEntity {

    private String cep;
    private String enderecoCompleto;
    @ManyToOne
    private Municipio municipio;




    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
