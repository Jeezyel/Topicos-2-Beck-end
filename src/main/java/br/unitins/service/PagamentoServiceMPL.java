package br.unitins.service;

import br.unitins.DTO.CarrinhoResponceDTO;
import br.unitins.DTO.PagamentoDTO;
import br.unitins.model.Carrinho;
import br.unitins.model.Pagamento;
import br.unitins.repository.CarrinhoRepository;
import br.unitins.repository.PagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.annotations.CollectionIdJavaType;

import java.time.LocalDateTime;

@ApplicationScoped
public class PagamentoServiceMPL implements PagamentoService {
    @Inject
    CarrinhoRepository carrinhoRepository;

    @Inject
    PagamentoRepository pagamentoRepository;


    @Override
    public CarrinhoResponceDTO finalizarCompra(Long idCarrinho, PagamentoDTO pagamentoDTO) {

        Carrinho carrinho = carrinhoRepository.findById(idCarrinho);






        Pagamento pagamento = new Pagamento();

        pagamento.setDatahora(LocalDateTime.now());
        pagamento.setQuantidadeParcela(pagamentoDTO.quantidadeParcela());
        pagamento.setTipoPagamento(pagamentoDTO.tipoPagamento());

        pagamentoRepository.persist(pagamento);





        carrinho.setPagamento(pagamento);

        carrinhoRepository.persist(carrinho);

        return new CarrinhoResponceDTO(carrinho);
    }
}


