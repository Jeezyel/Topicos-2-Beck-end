package br.unitins.DTO;


import br.unitins.model.Telefone;
import br.unitins.model.Usuario;

import java.util.List;

public record UsuarioResponceDTO(
        String nome,
        String cpf,
        List<Telefone> Telefone,
        long idEndereco,
        String login,
        String senha
) {
    public UsuarioResponceDTO(Usuario usuario){
        this(
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getEndereco().getId(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
