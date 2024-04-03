package br.unitins.service;

import br.unitins.model.ViaCep;
import br.unitins.teste.EnderecoTeste;
import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@ApplicationScoped
public class ViacepServiceMPL implements ViacepService{


    @Override
    public ViaCep ViaCep(String cep) throws Exception {


        URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String Ceep = "";

        StringBuilder jsonCep = new StringBuilder();

        while ((Ceep = br.readLine()) != null){

            jsonCep.append(Ceep);

        }

        ViaCep viaCep = new Gson().fromJson(jsonCep.toString(), ViaCep.class);


        return  viaCep;
    }
}
