package br.unitins.DTO;

import jakarta.validation.constraints.NotBlank;

public record CarrinhoDTO(

        ItemCompraDTO itemCompra,

        long usuario
) {
}
