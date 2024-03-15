package br.unitins.DTO;


import br.unitins.model.Endereco;
import br.unitins.model.Telefone;
import br.unitins.model.Usuario;

import java.util.List;

public record UsuarioResponceDTO(
        String nome,
        String cpf,
        List<Telefone> Telefone,
        List<Endereco> enderecos,
        String login,
        String senha
) {
    public UsuarioResponceDTO(Usuario usuario){
        this(

                usuario.getNome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getTodosEndereco(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
