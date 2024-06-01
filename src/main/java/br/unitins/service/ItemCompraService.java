package br.unitins.service;

import br.unitins.DTO.ItemCompraDTO;
import br.unitins.DTO.ItemCompraResponceDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ItemCompraService {

    List<ItemCompraResponceDTO> getAll(int page, int pageSize);

    ItemCompraResponceDTO create(ItemCompraDTO itemCompraDTO);

    ItemCompraResponceDTO update(Long id, ItemCompraDTO itemCompraDTO);

    void delete(Long id);

}
