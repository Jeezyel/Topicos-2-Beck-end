package br.unitins.DTO;


import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;
import br.unitins.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponceDTO(
        long idUsuario,
        String nome,

        LocalDate dataNacimento,
        String cpf,

        Contato contato,
        Endereco enderecosPrincipal,
        List<Endereco> enderecos,
        String fileName,

        String nomeImagem,
        String login,
        String senha
) {
    public UsuarioResponceDTO(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataNacimento(),
                usuario.getCpf(),
                usuario.getContato(),
                usuario.getEnderecoPrincipal(),
                usuario.getTodosEndereco(),
                usuario.getFileName(),
                usuario.getNomeImagem(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
