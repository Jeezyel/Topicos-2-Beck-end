package br.unitins.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Luminaria extends DefaultEntity {
    private String estilo;

    private String tipoDeFonteDeLuz;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cor")
    private Cor cor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    private Marca marca ;

    private String descrica;

    private  Float valor;

    public String getDescrica() {
        return descrica;
    }

    public void setDescrica(String descrica) {
        this.descrica = descrica;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTipoDeFonteDeLuz() {
        return tipoDeFonteDeLuz;
    }

    public void setTipoDeFonteDeLuz(String tipoDeFonteDeLuz) {
        this.tipoDeFonteDeLuz = tipoDeFonteDeLuz;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marcas) {
        this.marca = marcas;
    }
}
