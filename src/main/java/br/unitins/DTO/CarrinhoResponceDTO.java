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

        ItemCompraResponceDTO itemCompra,
        UsuarioResponceSimplesDTO usuario
) {
        public CarrinhoResponceDTO(Carrinho carrinho){

                this(
                        carrinho.getId(),
                        carrinho.getDataCriaçãoCarrinho(),
                        carrinho.getPagamento(),
                        CarrinhoResponceDTO.covertItemCompra(carrinho.getItemCompra()),
                        CarrinhoResponceDTO.covertUsuario(carrinho.getUsuario())
                );
        }

        private  static ItemCompraResponceDTO covertItemCompra (ItemCompra itemCompra){
                return new ItemCompraResponceDTO(itemCompra);
        }
        private static UsuarioResponceSimplesDTO covertUsuario(Usuario usuario){
                return new UsuarioResponceSimplesDTO(usuario);
        }
}
