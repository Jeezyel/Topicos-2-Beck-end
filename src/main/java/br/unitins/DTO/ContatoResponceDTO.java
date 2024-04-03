package br.unitins.DTO;

import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

import java.util.List;

public record ContatoResponceDTO(

        long idContato,

        long idUsuario,
        String telefones,

        String email
) {
    public ContatoResponceDTO(Contato contato){

        this(
                contato.getId(),
                contato.getUsuario().getId(),
                contato.getTelefone(),
                contato.getEmail()

        );

    }
}
