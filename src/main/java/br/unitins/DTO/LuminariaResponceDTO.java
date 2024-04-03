package br.unitins.DTO;

import br.unitins.model.Cor;
import br.unitins.model.Luminaria;
import br.unitins.model.Marca;

import java.util.List;

public record LuminariaResponceDTO(
        long idluminaria,
        String estilo,

        String tipoDeFonteDeLuz,

        List<Cor> cores,
        List<Marca> marcas
) {
        public LuminariaResponceDTO(Luminaria luminaria){
                this(
                        luminaria.getId(),
                        luminaria.getEstilo(),
                        luminaria.getTipoDeFonteDeLuz(),
                        luminaria.getCores(),
                        luminaria.getMarcas()
                );
        }
}
