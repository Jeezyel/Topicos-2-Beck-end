package br.unitins.DTO;

import br.unitins.model.Autor;
import br.unitins.model.CategoriaLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDTO (
        @NotBlank (message = "O titulo deve ser informdo ")
        String titulo,
        @NotBlank (message = "O autor deve ser informdo ")
        long autor,

        long editora,
        @NotNull (message = "o ano de publicação deve ser informado ")
        int anoPublicacao,
        @NotBlank (message = "O categoriaLivro deve ser informdo ")
        CategoriaLivro categoriaLivro,
        int numPaginas,

        String descricao,
        @NotNull (message = "o valor deve ser informado ")
        Float valor
){

}
