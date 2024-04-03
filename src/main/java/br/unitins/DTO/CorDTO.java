package br.unitins.DTO;

import jakarta.validation.constraints.NotBlank;

public record CorDTO(
        @NotBlank(message = "A cor deve ser informdo ")
        String corRgb,

        String descircao
) {
}
