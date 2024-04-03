package br.unitins.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Luminaria extends DefaultEntity {
    private String estilo;

    private String tipoDeFonteDeLuz;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cores", unique = true)
    private List<Cor> cores;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marcas", unique = true)
    private List<Marca> marcas ;

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

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}
