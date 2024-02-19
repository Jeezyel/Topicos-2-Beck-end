package br.unitins.DTO;

import br.unitins.model.Estado;
import br.unitins.model.Municipio;

import java.util.List;

public record EstadoResponceDTO(
        Long idEstado,
        String nome,
        String sigla
) {
    public  EstadoResponceDTO (Estado estado) {
        this(
                estado.getId(),
                estado.getNome(),
                estado.getSigla()
        );
    }
}
