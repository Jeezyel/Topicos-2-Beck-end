package br.unitins.service;


import java.io.File;

public interface FileService {
    // recursos basicos
    void salvar(Long id, String nomeImagem, byte[] imagem);

    File download(String nomeArquivo);

}
