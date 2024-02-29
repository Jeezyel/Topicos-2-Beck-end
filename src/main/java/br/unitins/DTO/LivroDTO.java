package br.unitins.DTO;

import jakarta.validation.constraints.NotBlank;

public record LivroDTO (
        @NotBlank (message = "O titulo deve ser informdo ")
        String titulo,
        @NotBlank (message = "O titulo deve ser autor ")
        String autor,
        int anoPublicacao,
        @NotBlank (message = "O titulo deve ser genero ")
        String genero,
        int numPaginas
){

}
