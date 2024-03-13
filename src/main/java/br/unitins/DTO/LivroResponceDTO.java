package br.unitins.DTO;

import br.unitins.model.CategoriaLivro;
import br.unitins.model.Livro;

public record LivroResponceDTO(
        long idLivro,
        String titulo,
        String autor,
        int anoPublicacao,
        CategoriaLivro categoriaLivro,  //nesse caso não vou colocar como id da categoria pq ja vai vim como uma
                                        //string = valor do enumerador CategoriaLivro TIPO se coloca o id quando
                                        // n quer colocar todo o dodo de categoria mais com e enum n tem problenma
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
