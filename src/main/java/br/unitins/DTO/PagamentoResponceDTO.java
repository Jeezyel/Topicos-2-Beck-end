package br.unitins.DTO;

import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;

import java.time.LocalDateTime;

public record PagamentoResponceDTO(
        LocalDateTime datahora,

        Integer quantidadeParcela,

        TipoPagamento tipoPagamento
) {
    public PagamentoResponceDTO(Pagamento pagamento){
        this(
                pagamento.getDatahora(),
                pagamento.getQuantidadeParcela(),
                pagamento.getTipoPagamento()
        );
    }
}
