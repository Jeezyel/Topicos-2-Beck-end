package br.unitins.DTO;

import br.unitins.model.ItemCompra;
import br.unitins.model.Livro;
import br.unitins.model.Luminaria;

import java.util.List;
import java.util.stream.Collectors;

public record ItemCompraResponceDTO(
        Double valorTotal,

        List<LivroSimplesResponceDTO>livros,

        List<LuminariaSimplesResponceDTO> luminarias
) {
    public ItemCompraResponceDTO (ItemCompra itemCompra){
        this(
                itemCompra.getValorTotal(),
                ItemCompraResponceDTO.converterLivros(itemCompra.getLivros()),
                ItemCompraResponceDTO.converterLuminaria(itemCompra.getLuminarias())
        );

    }

    private static List<LivroSimplesResponceDTO> converterLivros(List<Livro> livro){
        return livro.stream().map(LivroSimplesResponceDTO::new).collect(Collectors.toList());
    }

    private static List<LuminariaSimplesResponceDTO> converterLuminaria(List<Luminaria> luminaria){
        return luminaria.stream().map(LuminariaSimplesResponceDTO::new).collect(Collectors.toList());
    }
}
