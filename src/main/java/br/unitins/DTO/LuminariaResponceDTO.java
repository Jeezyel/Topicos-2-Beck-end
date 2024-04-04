package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Luminaria;
import br.unitins.model.Marca;

import java.util.List;

public record LuminariaResponceDTO(
        long idluminaria,
        String estilo,

        String tipoDeFonteDeLuz,

        long cor,
        long marca,

        String descricao,

        Float valor
) {
        public LuminariaResponceDTO(Luminaria luminaria){
                this(
                        luminaria.getId(),
                        luminaria.getEstilo(),
                        luminaria.getTipoDeFonteDeLuz(),
                        luminaria.getCor().getId(),
                        luminaria.getMarca().getId(),
                        luminaria.getDescrica(),
                        luminaria.getValor()
                );
        }
}
