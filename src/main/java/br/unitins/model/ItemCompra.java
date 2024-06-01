package br.unitins.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ItemCompra extends DefaultEntity {

    private Double valorTotal;

    @ManyToMany
    @JoinTable(name = "ItemCompra_Livro",
            joinColumns = @JoinColumn(name = "item_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "livros_id"))
    private List<Livro> livros ;

    @ManyToMany
    @JoinTable(name = "ItemCompra_Luminaria",
            joinColumns = @JoinColumn(name = "item_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "luminaria_id"))
    private List<Luminaria> luminarias ;


    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Luminaria> getLuminarias() {
        return luminarias;
    }

    public void setLuminarias(List<Luminaria> luminarias) {
        this.luminarias = luminarias;
    }
}
