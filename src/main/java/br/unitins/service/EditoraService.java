package br.unitins.service;

import br.unitins.DTO.EditoraDTO;
import br.unitins.DTO.EditoraResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface EditoraService {

    // recursos basicos
    List<EditoraResponceDTO> getAll();


    EditoraResponceDTO create(EditoraDTO editoraDTO);

    EditoraResponceDTO update(Long id, EditoraDTO editoraDTO);

    void delete(Long id);

    // recursos extras


    EditoraResponceDTO findById(long id);
}
