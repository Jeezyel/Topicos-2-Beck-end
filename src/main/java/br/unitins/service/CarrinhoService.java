package br.unitins.service;

import br.unitins.DTO.CarrinhoDTO;
import br.unitins.DTO.CarrinhoResponceDTO;
import br.unitins.DTO.ItemCompraDTO;
import br.unitins.DTO.PagamentoDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface CarrinhoService {

    List<CarrinhoResponceDTO> getAll(int page, int pageSize);


    CarrinhoResponceDTO create(CarrinhoDTO carrinhoDTO);



    CarrinhoResponceDTO update(Long id, CarrinhoDTO carrinhoDTO);

    CarrinhoResponceDTO AddCarrinho(Long idCarrinho, ItemCompraDTO itemCompraDTO);

    CarrinhoResponceDTO finalizarCompra(Long idCarrinho, PagamentoDTO pagamentoDTO);
    void delete(Long id);

    long count();
    // recursos extras


    CarrinhoResponceDTO findById(long id);
}
