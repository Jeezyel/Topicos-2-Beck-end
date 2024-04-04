package br.unitins.service;

import br.unitins.DTO.LivroDTO;
import br.unitins.DTO.LivroResponceDTO;
import br.unitins.DTO.MunicipiosDTO;
import br.unitins.DTO.MunicipiosResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface LivroService {

    // recursos basicos
    List<LivroResponceDTO> getAll(int page , int pageSize);


    LivroResponceDTO create(LivroDTO livroDTO);

    LivroResponceDTO update(Long id, LivroDTO livroDTO);

    void delete(Long id);

    // recursos extras

    List<LivroResponceDTO> findByNome(String nome);

    long count();
}
