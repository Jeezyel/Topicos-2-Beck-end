package br.unitins.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contato extends DefaultEntity {
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id-contato", unique = true)
//    private List<Telefone> telefones;


    private String telefone;



    private String email;




//    public List<Telefone> getTelefones() {
//        return telefones;
//    }
//
//    public void setTelefones(List<Telefone> telefones) {
//        this.telefones = telefones;
//    }



    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
