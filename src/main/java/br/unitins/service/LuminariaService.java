package br.unitins.service;

import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.DTO.LuminariaDTO;
import br.unitins.DTO.LuminariaResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface LuminariaService {

    // recursos basicos
    List<LuminariaResponceDTO> getAll();


    LuminariaResponceDTO create(LuminariaDTO luminariaDTO);

    LuminariaResponceDTO update(Long id, LuminariaDTO luminariaDTO);

    void delete(Long id);

    // recursos extras


    LuminariaResponceDTO findById(long id);
}
