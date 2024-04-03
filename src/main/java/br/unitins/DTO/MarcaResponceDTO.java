package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Marca;

public record MarcaResponceDTO(
        long idMarca,
        String descricao,
        String nome
) {
        public MarcaResponceDTO(Marca marca){
                this(
                        marca.getId(),
                        marca.getDescricao(),
                        marca.getNome()
                );
        }
}
