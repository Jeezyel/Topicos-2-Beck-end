package br.unitins.repository;

import br.unitins.model.Autor;
import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AuthRepository implements PanacheRepository<Usuario> {
    public PanacheQuery<Usuario> findByUsernameAndSenha(String username, String senha) {
        return find("pessoa.usuario.username = ?1 AND  pessoa.usuario.senha = ?2", username, senha);
    }

}
