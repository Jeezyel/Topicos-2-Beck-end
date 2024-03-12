package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Telefone extends DefaultEntity {
    private String codegoDeArea;
    private String numero;
    @OneToOne
    private Usuario usuario;

    public String getCodegoDeArea() {
        return codegoDeArea;
    }

    public void setCodegoDeArea(String codegoDeArea) {
        this.codegoDeArea = codegoDeArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
