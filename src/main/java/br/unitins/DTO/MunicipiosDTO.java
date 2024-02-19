package br.unitins.DTO;

import br.unitins.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MunicipiosDTO(
        @NotBlank(message = "o Campo nome deve ser informado")
        String nome,
        @NotNull(message = "o Campo idEstado deve ser informado")
        Estado estado
) {
}
