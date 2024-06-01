package br.unitins.DTO;

import br.unitins.model.Carrinho;
import br.unitins.model.ItemCompra;
import br.unitins.model.Pagamento;
import br.unitins.model.Usuario;

import java.time.LocalDateTime;

public record CarrinhoResponceDTO(
        long idCarrinho,

        LocalDateTime dataCriaçãoCarrinho,

        Pagamento pagamento,

        ItemCompra itemCompra,
        Usuario usuario
) {
        public CarrinhoResponceDTO(Carrinho carrinho){
                this(
                        carrinho.getId(),
                        carrinho.getDataCriaçãoCarrinho(),
                        carrinho.getPagamento(),
                        carrinho.getItemCompra(),
                        carrinho.getUsuario()
                );
        }
}
