package br.unitins.DTO;

import br.unitins.model.ItemCompra;
import br.unitins.model.Livro;
import br.unitins.model.Luminaria;

import java.util.List;

public record ItemCompraResponceDTO(
        Double valorTotal,

        List<Livro>livros,

        List<Luminaria> luminarias
) {
    public ItemCompraResponceDTO (ItemCompra itemCompra){
        this(
                itemCompra.getValorTotal(),
                itemCompra.getLivros(),
                itemCompra.getLuminarias()
        );

    }
}
