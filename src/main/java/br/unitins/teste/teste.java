package br.unitins.teste;


import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class teste {

    public static String testeViaCep( String Cep) throws Exception{
        URL url = new URL("https://viacep.com.br/ws/"+Cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String Ceep = "";

        StringBuilder jsonCep = new StringBuilder();

        while ((Ceep = br.readLine()) != null){

            jsonCep.append(Ceep);

        }

        return jsonCep.toString();
    }

    public static EnderecoTeste enderecoTeste( String Cep) throws Exception{
        URL url = new URL("https://viacep.com.br/ws/"+Cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String Ceep = "";

        StringBuilder jsonCep = new StringBuilder();

        while ((Ceep = br.readLine()) != null){

            jsonCep.append(Ceep);

        }

        EnderecoTeste enderecoTesteAux = new Gson().fromJson(jsonCep.toString(),EnderecoTeste.class);

        EnderecoTeste enderecoTeste = new EnderecoTeste();

        enderecoTeste.setCep(enderecoTesteAux.getCep());
        enderecoTeste.setLogradouro(enderecoTesteAux.getLogradouro());
        enderecoTeste.setComplemento(enderecoTesteAux.getComplemento());
        enderecoTeste.setBairro(enderecoTesteAux.getBairro());
        enderecoTeste.setLocalidade(enderecoTesteAux.getLocalidade());
        enderecoTeste.setUf(enderecoTesteAux.getUf());

        return enderecoTeste;
    }







    public static void main(String[] args) {


        List<String> nome = new ArrayList<>();



        nome.add("nome1");
        nome.add("nome2");
        nome.add("nome3");
        nome.add("nome4");

        nome.add(0, "5nomes");

        System.out.println(nome);

        try {
            System.out.println(testeViaCep("77024678"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
