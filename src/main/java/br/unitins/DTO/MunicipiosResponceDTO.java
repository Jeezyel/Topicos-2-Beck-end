package br.unitins.DTO;

import br.unitins.model.Municipio;

public record MunicipiosResponceDTO(
        String nome
) {
    public MunicipiosResponceDTO (Municipio municipio){
        this(
                municipio.getNome()
        );
    }
}
