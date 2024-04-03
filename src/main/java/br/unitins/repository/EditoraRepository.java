package br.unitins.repository;

import br.unitins.model.Cor;
import br.unitins.model.Editora;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EditoraRepository implements PanacheRepository<Editora> {
    public List<Editora> findByNome(String cnpj){
        if (cnpj == null)
            return null;
        return find("UPPER(cnpj) LIKE ?1 ", "%"+cnpj.toUpperCase()+"%").list();
    }

}
