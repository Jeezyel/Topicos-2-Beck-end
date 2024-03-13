package br.unitins.repository;

import br.unitins.model.Livro;
import br.unitins.model.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    public List<Livro> findByNome(String titilo){
        if (titilo == null)
            return null;
        return find("UPPER(titilo) LIKE ?1 ", "%"+titilo.toUpperCase()+"%").list();
    }

    public List<Livro> findByCategoria(String categoria){
        if (categoria == null)
            return null;
        return find("UPPER(categoria) LIKE ?1 ", "%"+categoria.toUpperCase()+"%").list();
    }
}
