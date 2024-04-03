package br.unitins.DTO;

import br.unitins.model.Telefone;
import jakarta.validation.constraints.NotBlank;

public record TelefoneResponceDTO(
        long idTelefone,
        String codegoDeArea,
        String numero
) {
        public TelefoneResponceDTO(Telefone telefone){
                this(
                        telefone.getId(),
                        telefone.getCodegoDeArea(),
                        telefone.getNumero()
                );
        }
}
