package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.model.ViaCep;
import br.unitins.teste.EnderecoTeste;
import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;

import java.util.List;

@ApplicationScoped
public interface ViacepService {

    ViaCep ViaCep(String cep)throws Exception;

    EnderecoResponceDTO enderecoCep(String cep) throws Exception;

}
