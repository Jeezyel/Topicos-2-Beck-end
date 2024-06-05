package br.unitins.DTO;


import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Perfil;
import br.unitins.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record UsuarioResponceSimplesDTO(
        long idUsuario,
        String nome,

        Set<Perfil> perfil,

        LocalDate dataNacimento,
        String cpf,
        String cep,
        String email,
        String senha,

        String nomeImagem
) {
    public UsuarioResponceSimplesDTO(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getPerfis(),
                usuario.getDataNacimento(),
                usuario.getCpf(),
                usuario.getCep(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getNomeImagem()
        );
    }
}
