package br.unitins.DTO;

import br.unitins.model.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ContatoDTO(

        long idUsuario,
        String telefones,

        String email
) {
}
