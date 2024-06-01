package br.unitins.DTO;

import br.unitins.model.Livro;
import br.unitins.model.Luminaria;

import java.util.List;

public record ItemCompraDTO(

        List<Long>livros,

        List<Long> luminarias
) {
}
