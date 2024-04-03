package br.unitins.repository;

import br.unitins.model.Cor;
import br.unitins.model.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CorRepository implements PanacheRepository<Cor> {
    public List<Cor> findByNome(String corRgb){
        if (corRgb == null)
            return null;
        return find("UPPER(corRgb) LIKE ?1 ", "%"+corRgb.toUpperCase()+"%").list();
    }

}
