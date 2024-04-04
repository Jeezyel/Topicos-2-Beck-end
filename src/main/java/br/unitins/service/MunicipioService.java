package br.unitins.service;

import br.unitins.DTO.EstadoDTO;
import br.unitins.DTO.EstadoResponceDTO;
import br.unitins.DTO.MunicipiosDTO;
import br.unitins.DTO.MunicipiosResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface MunicipioService {

    // recursos basicos
    List<MunicipiosResponceDTO> getAll(int page , int pageSize);


    MunicipiosResponceDTO create(MunicipiosDTO municipioDTO);

    MunicipiosResponceDTO update(Long id, MunicipiosDTO municipioDTO);

    void delete(Long id);

    // recursos extras

    List<MunicipiosResponceDTO> findByNome(String nome);

    long count();
}
