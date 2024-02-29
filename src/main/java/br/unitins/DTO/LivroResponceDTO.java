package br.unitins.DTO;

import br.unitins.model.Livro;
import jakarta.validation.constraints.NotBlank;

public record LivroResponceDTO(
        long idLivro,
        String titulo,
        String autor,
        int anoPublicacao,
        String genero,
        int numPaginas
){
        public LivroResponceDTO(Livro livro){
                this(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getAnoPublicacao(),
                        livro.getGenero(),
                        livro.getNumPaginas()
                );

        }

}
