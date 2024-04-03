package br.unitins.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contato extends DefaultEntity {
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id-contato", unique = true)
//    private List<Telefone> telefones;

    private List<String> telefone;



    private List<String> email;




//    public List<Telefone> getTelefones() {
//        return telefones;
//    }
//
//    public void setTelefones(List<Telefone> telefones) {
//        this.telefones = telefones;
//    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }
}
