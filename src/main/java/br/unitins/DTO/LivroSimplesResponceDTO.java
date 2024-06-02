package br.unitins.DTO;

import br.unitins.model.Autor;
import br.unitins.model.CategoriaLivro;
import br.unitins.model.Editora;
import br.unitins.model.Livro;

public record LivroSimplesResponceDTO(
        long idLivro,
        String titulo,

        int anoPublicacao,
        CategoriaLivro categoriaLivro,  //nesse caso não vou colocar como id da categoria pq ja vai vim como uma
                                        //string = valor do enumerador CategoriaLivro TIPO se coloca o id quando
                                        // n quer colocar todo o dodo de categoria mais com e enum n tem problenma
        int numPaginas,

        String descricao,

        Float valor,

        Integer quantidadeProduto,

        String nomeImagem
){
        public LivroSimplesResponceDTO(Livro livro){
                this(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAnoPublicacao(),
                        livro.getCategoriaLivro(),
                        livro.getNumPaginas(),
                        livro.getDescricao(),
                        livro.getValor(),
                        livro.getQuantidadeProduto(),
                        livro.getNomeImagem()
                );

        }

}
