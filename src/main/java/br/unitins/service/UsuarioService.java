package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.UsuarioDTO;
import br.unitins.DTO.UsuarioResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface UsuarioService {

    // recursos basicos
    List<UsuarioResponceDTO> getAll();


    UsuarioResponceDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponceDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    // recursos extras

    List<UsuarioResponceDTO> findByNome(String nome);

    UsuarioResponceDTO findById(long id);

    long count();
}
