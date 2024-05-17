package br.unitins.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario extends DefaultEntity{

    @Column(length = 60 )
    private String nome;

    private LocalDate dataNacimento;

    @Column(length = 14)
    private String cpf;

    @ManyToOne()
    @JoinColumn(name = "id_contato")
    private Contato contato;

    @ManyToOne
    @JoinColumn(name = "id_enderecoprincipal")
    private Endereco enderecoPrincipal;

    @OneToMany()
    @JoinColumn(name = "id_todosendereco")
    private List<Endereco> todosEndereco;

    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis;

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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public LocalDate getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(LocalDate dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

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
