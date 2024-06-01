package br.unitins.DTO;

import br.unitins.model.Luminaria;

import java.util.List;

public record LuminariaResponceDTO(
        long idluminaria,
        String estilo,

        String tipoDeFonteDeLuz,

        long cor,
        long marca,

        String descricao,

        Float valor,

        Integer quantidadeProduto,

        String nomeImagem
) {
        public LuminariaResponceDTO(Luminaria luminaria){
                this(
                        luminaria.getId(),
                        luminaria.getEstilo(),
                        luminaria.getTipoDeFonteDeLuz(),
                        luminaria.getCor().getId(),
                        luminaria.getMarca().getId(),
                        luminaria.getDescricao(),
                        luminaria.getValor(),
                        luminaria.getQuantidadeProduto(),
                        luminaria.getNomeImagem()
                );
        }
}
