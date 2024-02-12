package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Municipio extends DefaultEntity{

    @Column( nullable = false ) 
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
