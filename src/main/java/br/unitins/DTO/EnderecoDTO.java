package br.unitins.DTO;

import br.unitins.model.Municipio;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotBlank(message = "O CEP deve ser informdo ")
         String cep,
        @NotBlank (message = "O Endereço deve ser informdo ")
         String enderecoCompleto,
         @NotNull(message = "o Id do Municipios deve ser informado")
         long idMunicipio
) {
}
