package br.unitins.service;

import br.unitins.DTO.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface PagamentoService {

    CarrinhoResponceDTO finalizarCompra(Long idCarrinho, PagamentoDTO pagamentoDTO);
}


