package br.unitins.repository;

import br.unitins.model.Livro;
import br.unitins.model.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    public List<Livro> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

    public List<Livro> findByCategoria(String categoria){
        if (categoria == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+categoria.toUpperCase()+"%").list();
    }
}
