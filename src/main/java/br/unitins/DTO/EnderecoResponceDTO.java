package br.unitins.DTO;

import br.unitins.model.Endereco;

public record EnderecoResponceDTO(
        long idEndereco,
         String cep,
         String enderecoCompleto,
         long idMunicipio
) {
    public EnderecoResponceDTO(Endereco endereco){

        this(
                endereco.getId(),
                endereco.getCep(),
                endereco.getEnderecoCompleto(),
                endereco.getMunicipio().getId()
        );

    }
}
