package br.unitins.repository;

import br.unitins.model.Autor;
import br.unitins.model.Cor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor> {
    public List<Autor> findByNome(String nomeArtistico){
        if (nomeArtistico == null)
            return null;
        return find("UPPER(nomeArtistico) LIKE ?1 ", "%"+nomeArtistico.toUpperCase()+"%").list();
    }

}
