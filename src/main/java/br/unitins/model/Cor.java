package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Cor extends DefaultEntity {
    private String corRgb;

    private String descricao;

    public String getCorRgb() {
        return corRgb;
    }

    public void setCorRgb(String corRgb) {
        this.corRgb = corRgb;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
