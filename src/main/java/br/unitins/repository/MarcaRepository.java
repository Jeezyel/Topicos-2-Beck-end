package br.unitins.repository;

import br.unitins.model.Cor;
import br.unitins.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {
    public List<Marca> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(corRgb) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

}
