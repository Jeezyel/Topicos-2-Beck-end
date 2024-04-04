package br.unitins.service;

import br.unitins.DTO.AutorDTO;
import br.unitins.DTO.AutorResponceDTO;
import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.model.Autor;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface AutorService {

    // recursos basicos
    List<AutorResponceDTO> getAll();


    AutorResponceDTO create(AutorDTO autorDTO);

    AutorResponceDTO update(Long id, AutorDTO autorDTO);

    void delete(Long id);

    // recursos extras


    AutorResponceDTO findById(long id);
}
