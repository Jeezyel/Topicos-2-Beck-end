package br.unitins.service;

import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.DTO.MarcaDTO;
import br.unitins.DTO.MarcaResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface MarcaService {

    // recursos basicos
    List<MarcaResponceDTO> getAll();


    MarcaResponceDTO create(MarcaDTO marcaDTO);

    MarcaResponceDTO update(Long id, MarcaDTO marcaDTO);

    void delete(Long id);

    // recursos extras


    MarcaResponceDTO findById(long id);
}
