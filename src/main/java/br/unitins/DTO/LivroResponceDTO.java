package br.unitins.DTO;

import br.unitins.model.CategoriaLivro;
import br.unitins.model.Livro;

public record LivroResponceDTO(
        long idLivro,
        String titulo,
        String autor,
        int anoPublicacao,
        CategoriaLivro categoriaLivro,
        int numPaginas
){
        public LivroResponceDTO(Livro livro){
                this(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getAnoPublicacao(),
                        livro.getCategoriaLivro(),
                        livro.getNumPaginas()
                );

        }

}
