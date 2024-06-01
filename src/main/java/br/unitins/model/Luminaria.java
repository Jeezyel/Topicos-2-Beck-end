package br.unitins.model;

import jakarta.persistence.*;
import jakarta.ws.rs.FormParam;

import java.util.List;

@Entity
public class Luminaria extends Produto {
    private String estilo;

    private String tipoDeFonteDeLuz;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cor")
    private Cor cor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    private Marca marca ;

    private String nomeImagem;




    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
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
