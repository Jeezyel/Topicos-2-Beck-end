package br.unitins.DTO;

import jakarta.validation.constraints.NotBlank;

public record MarcaDTO(
        @NotBlank(message = "o nome deve ser informdo ")
        String nome,
        @NotBlank(message = "o descircao deve ser informdo ")
        String descircao
) {
}
