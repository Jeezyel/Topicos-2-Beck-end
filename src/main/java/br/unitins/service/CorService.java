package br.unitins.service;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface CorService {

    // recursos basicos
    List<CorResponceDTO> getAll(int page , int pageSize);


    CorResponceDTO create(CorDTO corDTO);

    CorResponceDTO update(Long id, CorDTO corDTO);

    void delete(Long id);

    // recursos extras


    CorResponceDTO findById(long id);
}
