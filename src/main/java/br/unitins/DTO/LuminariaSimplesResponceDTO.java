package br.unitins.DTO;

import br.unitins.model.Luminaria;

public record LuminariaSimplesResponceDTO(
        long idluminaria,
        String estilo,

        String tipoDeFonteDeLuz,

        long cor,

        String descricao,

        Float valor,

        Integer quantidadeProduto,

        String nomeImagem
) {
        public LuminariaSimplesResponceDTO(Luminaria luminaria){
                this(
                        luminaria.getId(),
                        luminaria.getEstilo(),
                        luminaria.getTipoDeFonteDeLuz(),
                        luminaria.getCor().getId(),
                        luminaria.getDescricao(),
                        luminaria.getValor(),
                        luminaria.getQuantidadeProduto(),
                        luminaria.getNomeImagem()
                );
        }
}
