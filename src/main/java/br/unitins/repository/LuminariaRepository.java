package br.unitins.repository;

import br.unitins.model.Cor;
import br.unitins.model.Luminaria;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class LuminariaRepository implements PanacheRepository<Luminaria> {
    public List<Luminaria> findByNome(String estilo){
        if (estilo == null)
            return null;
        return find("UPPER(estilo) LIKE ?1 ", "%"+estilo.toUpperCase()+"%").list();
    }

    public PanacheQuery<Luminaria> findByNomePanacheQuery(String estilo){
        if (estilo == null)
            return null;
        return find("UPPER(estilo) LIKE ?1 ", "%"+estilo.toUpperCase()+"%");
    }

}
