package br.unitins.model;

import jakarta.persistence.*;

@Entity
public class Livro extends Produto {
    private String titulo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editora")
    private Editora editora;
    private int anoPublicacao;

    @Enumerated(EnumType.STRING)
    private CategoriaLivro categoriaLivro;
    private int numPaginas;

    private String nomeImagem;




    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public CategoriaLivro getCategoriaLivro() {
        return categoriaLivro;
    }

    public void setCategoriaLivro(CategoriaLivro categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
}
