package br.unitins.repository;

import br.unitins.model.Contato;
import br.unitins.model.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ContatoRepository implements PanacheRepository<Contato> {
    public List<Contato> findByEmail(String email){
        if (email == null)
            return null;
        return find("UPPER(email) LIKE ?1 ", "%"+email.toUpperCase()+"%").list();
    }

}
