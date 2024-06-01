package br.unitins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;

@Entity
public class Carrinho extends DefaultEntity {

    private LocalDateTime dataCriaçãoCarrinho;

    @ManyToOne
    private Pagamento pagamento;

    @ManyToOne
    private ItemCompra itemCompra;

    @ManyToOne
    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public LocalDateTime getDataCriaçãoCarrinho() {
        return dataCriaçãoCarrinho;
    }

    public void setDataCriaçãoCarrinho(LocalDateTime dataCriaçãoCarrinho) {
        this.dataCriaçãoCarrinho = dataCriaçãoCarrinho;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
