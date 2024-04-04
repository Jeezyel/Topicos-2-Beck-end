package br.unitins.service;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ContatoService {

    // recursos basicos
    List<ContatoResponceDTO> getAll(int page , int pageSize);


    ContatoResponceDTO create(ContatoDTO contatoDTO);

    ContatoResponceDTO update(Long id, ContatoDTO contatoDTO);

    void delete(Long id);

    // recursos extras

    List<ContatoResponceDTO> findByEmail(String email);

    ContatoResponceDTO findById(long id);

    long count();
}
