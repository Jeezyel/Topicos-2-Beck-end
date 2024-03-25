package br.unitins.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Contato extends DefaultEntity {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone", unique = true)
    private List<Telefone> telefones;

    private List<String> email;




    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}
