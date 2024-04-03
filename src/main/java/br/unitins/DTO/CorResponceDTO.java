package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Telefone;

public record CorResponceDTO(
        long idCor,
        String descricao,
        String corRgb
) {
        public CorResponceDTO(Cor cor){
                this(
                        cor.getId(),
                        cor.getDescricao(),
                        cor.getCorRgb()
                );
        }
}
