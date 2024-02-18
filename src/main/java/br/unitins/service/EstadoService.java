package br.unitins.service;

import br.unitins.DTO.EstadoDTO;
import br.unitins.DTO.EstadoResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface EstadoService {

    // recursos basicos
    List<EstadoResponceDTO> getAll();


    EstadoResponceDTO create(EstadoDTO estadosDTO);

    EstadoResponceDTO update(Long id, EstadoDTO estadosDTO);

    void delete(Long id);

    // recursos extras

    List<EstadoResponceDTO> findByNome(String nome);

    long count();
}
