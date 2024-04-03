package br.unitins.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutorDTO(
        @NotNull(message = "O id-usuario deve ser informdo ")
        long idUsurio,

        String nomeAtistico
) {
}
