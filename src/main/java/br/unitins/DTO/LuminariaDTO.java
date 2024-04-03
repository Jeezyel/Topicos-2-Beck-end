package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Marca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record LuminariaDTO(
        @NotBlank(message = "o estilo de luminara deve ser informdo ")
        String estilo,

        String tipoDeFonteDeLuz,

        @NotNull(message = "a cor deve ser informado")
        List<Cor> cores,
        @NotNull(message = "a marca deve ser informado")
        List<Marca> marcas
) {
}
