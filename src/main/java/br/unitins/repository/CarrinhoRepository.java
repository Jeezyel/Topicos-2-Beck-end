package br.unitins.repository;

import br.unitins.model.Carrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class CarrinhoRepository implements PanacheRepository<Carrinho> {

    public List<Carrinho> findByNome(Integer idUsuario ){
        if (idUsuario == null)
            return null;
        return find("UPPER(idUsuario) LIKE ?1 ", idUsuario).list();
    }
}
