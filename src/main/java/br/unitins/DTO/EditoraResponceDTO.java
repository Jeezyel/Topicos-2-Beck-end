package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Editora;

public record EditoraResponceDTO(
        long idEditora,
        String cnpj,
        String nome,
        String Telefone,
        long endereco
) {
        public EditoraResponceDTO(Editora editora){
                this(
                        editora.getId(),
                        editora.getCnpj(),
                        editora.getNome(),
                        editora.getTelefone(),
                        editora.getEndereco().getId()
                );
        }
}
