package br.unitins.repository;

import br.unitins.model.ItemCompra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class ItemCompraRepository implements PanacheRepository<ItemCompra> {

    public List<ItemCompra> findByValor(Double valor ){
        if (valor == null)
            return null;
        return find("UPPER(valor) ", valor).list();
    }
}
