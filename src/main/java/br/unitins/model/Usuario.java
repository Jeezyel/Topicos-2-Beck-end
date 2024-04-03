package br.unitins.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario extends DefaultEntity{

    @Column(length = 60 )
    private String nome;

    @Column(length = 14)
    private String cpf;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_contato", unique = true)
//    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_enderecoprincipal", unique = true)
    private Endereco enderecoPrincipal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_todosendereco", unique = true)
    private List<Endereco> todosEndereco;

    private String login;

    private String senha;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public Contato getContato() {
//        return contato;
//    }
//
//    public void setContato(Contato contato) {
//        this.contato = contato;
//    }

    public Endereco getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public List<Endereco> getTodosEndereco() {
        return todosEndereco;
    }

    public void setTodosEndereco(List<Endereco> todosEndereco) {
        this.todosEndereco = todosEndereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
