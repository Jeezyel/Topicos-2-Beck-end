package br.unitins.teste;

import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) {
        List<String> nome = new ArrayList<>();

        nome.add("nome1");
        nome.add("nome2");
        nome.add("nome3");
        nome.add("nome4");

        nome.add(0, "5nomes");

        System.out.println(nome);


    }
}
