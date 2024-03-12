package br.unitins.DTO;

import br.unitins.model.CategoriaLivro;
import jakarta.validation.constraints.NotBlank;

public record LivroDTO (
        @NotBlank (message = "O titulo deve ser informdo ")
        String titulo,
        @NotBlank (message = "O autor deve ser informdo ")
        String autor,
        int anoPublicacao,
        @NotBlank (message = "O categoriaLivro deve ser informdo ")
        CategoriaLivro categoriaLivro,
        int numPaginas
){

}
