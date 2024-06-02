package br.unitins.service;

import br.unitins.DTO.ItemCompraDTO;
import br.unitins.DTO.ItemCompraResponceDTO;
import br.unitins.model.ItemCompra;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ItemCompraService {

    List<ItemCompraResponceDTO> getAll(int page, int pageSize);

    ItemCompraResponceDTO create(ItemCompraDTO itemCompraDTO);

    public ItemCompra createItemCompra(ItemCompraDTO itemCompraDTO);

    ItemCompraResponceDTO update(Long idCarrinho, ItemCompraDTO itemCompraDTO);

    ItemCompra updateItemCompra(Long idCarrinho, ItemCompraDTO itemCompraDTO);

    void delete(Long id);

}
