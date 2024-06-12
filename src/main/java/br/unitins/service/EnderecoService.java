package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.EstadoDTO;
import br.unitins.DTO.EstadoResponceDTO;
import br.unitins.model.Endereco;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface EnderecoService {

    // recursos basicos
    List<EnderecoResponceDTO> getAll();


    EnderecoResponceDTO create(EnderecoDTO enderecoDTO);

    EnderecoResponceDTO update(Long id, EnderecoDTO enderecoDTO);

    EnderecoResponceDTO enderecoCep(String cep) throws Exception;

    void delete(Long id);

    // recursos extras

    List<EnderecoResponceDTO> findByCep(String cep);

    EnderecoResponceDTO findById(long id);

    long count();
}
