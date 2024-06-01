package br.unitins.service;

import br.unitins.DTO.*;
import br.unitins.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

import java.util.List;

@ApplicationScoped
public interface UsuarioService {

    // recursos basicos
    List<UsuarioResponceDTO> getAll(int page , int pageSize);


    UsuarioResponceDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponceSimplesDTO create(UsuarioSimplesDTO usuarioSimplesDTO);

    UsuarioResponceDTO update(Long id, UsuarioDTO usuarioDTO);

    Boolean alterarSenha (Long id, String senhaAntiga, String novaSenha);

    Boolean alterarSenha (String nome, String senhaAntiga, String novaSenha);



    void delete(Long id);

    // recursos extras

    List<UsuarioResponceDTO> findByNome(String nome);// aqui pode ter uma falha de Segurança
    // por conta de esta mandando para o frot todos os dados de todos usuario com o mesmo nome

    UsuarioResponceDTO findById(long id);

    UsuarioResponceDTO addAddress(long idUsuario, EnderecoDTO enderecoDTO );

    UsuarioResponceDTO mainAddress(long idUsuario, String CEP );

    long count();

    Usuario findByUsernameAndSenha(String login, String senha);
}
