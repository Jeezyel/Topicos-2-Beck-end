package br.unitins.repository;

import br.unitins.model.Estado;
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
    public Usuario findByNome(String cpf){
        if (cpf == null)
            return null;
        return find("UPPER(cpf) LIKE ?1 ", "%"+cpf.toUpperCase()+"%").firstResult();
    }
}
