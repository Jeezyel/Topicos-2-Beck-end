package br.unitins.repository;

import br.unitins.model.Estado;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findByListaNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
    public Usuario findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").firstResult();
    }

    public Usuario findByLoginAndSenha(String login, String senha){
        if (login == null || senha == null)
            return null;

        return find("login = ?1 AND senha = ?2 ", login, senha).firstResult();
    }

    public PanacheQuery<Usuario> findByUsernameAndSenha(String login, String senha) {
        if (login == null || senha == null)
            return null;
        return find("login = ?1 AND  senha = ?2", login, senha);
    }
}
