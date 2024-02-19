package br.unitins.DTO;

import br.unitins.model.Estado;
import br.unitins.model.Municipio;

public record MunicipiosResponceDTO(
        long idMunicipio,
        String nome,

        Estado estado
) {
    public MunicipiosResponceDTO (Municipio municipio){
        this(
                municipio.getId(),
                municipio.getNome(),
                municipio.getEstado()
        );
    }
}
