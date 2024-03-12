package br.unitins.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario extends DefaultEntity{

    @Column(length = 60)
    private String nome;

    @Column(length = 14)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone", unique = true)
    private List<Telefone> telefone;

    @OneToOne()
    @JoinColumn(name = "id_endereco", unique = true)
    private Endereco endereco;

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

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
