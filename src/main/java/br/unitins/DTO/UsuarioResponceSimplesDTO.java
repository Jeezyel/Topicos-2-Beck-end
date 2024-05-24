package br.unitins.DTO;


import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponceSimplesDTO(
        long idUsuario,
        String nome,
        LocalDate dataNacimento,
        String cpf,
        String cep,
        String email,
        String senha
) {
    public UsuarioResponceSimplesDTO(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataNacimento(),
                usuario.getCpf(),
                usuario.getCep(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
