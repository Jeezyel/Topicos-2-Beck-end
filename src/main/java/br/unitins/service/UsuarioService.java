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
    List<UsuarioResponceDTO> getAll(int page , int pageSize);


    UsuarioResponceDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponceDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    // recursos extras

    List<UsuarioResponceDTO> findByNome(String nome);// aqui pode ter uma falha de Segurança
    // por conta de esta mandando para o frot todos os dados de todos usuario com o mesmo nome

    UsuarioResponceDTO findById(long id);

    UsuarioResponceDTO addAddress(long idUsuario, EnderecoDTO enderecoDTO );

    UsuarioResponceDTO mainAddress(long idUsuario, String CEP );

    long count();
}
