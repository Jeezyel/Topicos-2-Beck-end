package br.unitins.DTO;

import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

import java.util.List;

public record ContatoResponceDTO(

        long idContato,
        List<String> telefones,

        List<String> email
) {
    public ContatoResponceDTO(Contato contato){

        this(
                contato.getId(),
                contato.getTelefone(),
                contato.getEmail()

        );

    }
}
