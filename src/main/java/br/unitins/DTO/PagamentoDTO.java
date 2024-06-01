package br.unitins.DTO;

import br.unitins.model.TipoPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record PagamentoDTO(

        Integer quantidadeParcela,

        TipoPagamento tipoPagamento
) {
}
