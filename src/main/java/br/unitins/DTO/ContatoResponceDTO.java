package br.unitins.DTO;

import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

import java.util.List;

public record ContatoResponceDTO(

        long idContato,
        List<Telefone> telefones,

        List<String> email
) {
    public ContatoResponceDTO(Contato contato){

        this(
                contato.getId(),
                contato.getTelefones(),
                contato.getEmail()

        );

    }
}
