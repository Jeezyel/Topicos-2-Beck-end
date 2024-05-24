package br.unitins.teste;

import br.unitins.model.Contato;
import br.unitins.model.DefaultEntity;
import br.unitins.model.Endereco;
import br.unitins.model.Perfil;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class UsuarioTeste  {

    private String nome;

    private String cpf;


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
