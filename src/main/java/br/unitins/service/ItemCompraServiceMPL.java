package br.unitins.service;

import br.unitins.DTO.CarrinhoDTO;
import br.unitins.DTO.CarrinhoResponceDTO;
import br.unitins.DTO.ItemCompraDTO;
import br.unitins.DTO.ItemCompraResponceDTO;
import br.unitins.model.Carrinho;
import br.unitins.model.ItemCompra;
import br.unitins.model.Livro;
import br.unitins.model.Luminaria;
import br.unitins.repository.ItemCompraRepository;
import br.unitins.repository.LivroRepository;
import br.unitins.repository.LuminariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemCompraServiceMPL implements ItemCompraService {

    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    LivroRepository livroRepository;

    @Inject
    LuminariaRepository luminariaRepository;

    @Override
    public List<ItemCompraResponceDTO> getAll(int page, int pageSize) {
        List<ItemCompra> list = itemCompraRepository.findAll().page(page,pageSize).list();
        return list.stream().map(ItemCompraResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public ItemCompraResponceDTO create(ItemCompraDTO itemCompraDTO) {
        ItemCompra itemCompra = new ItemCompra();

        if (itemCompra == null){
            throw new IllegalArgumentException("ItemCompra não pode ser nulo");
        } else if (itemCompra.getLivros() == null) {
            itemCompra.setLivros(new ArrayList<Livro>());
        }

        if (itemCompraDTO.livros().size() > 0) {

            // List<Livro> livros = itemCompra.getLivros();

            for (int i = 0; i <= itemCompraDTO.livros().size(); i++) {
                int index = 0;
                Livro livro = livroRepository.findById(itemCompraDTO.livros().get(index));

                if (index == 0)
                    itemCompra.setValorTotal(livro.getValor().doubleValue());

                itemCompra.setValorTotal(itemCompra.getValorTotal() + livro.getValor().doubleValue());

                itemCompra.getLivros().add(livro);

                index++;
            }

            // itemCompra.setLivros(livros);
        }
        if (itemCompra.getLuminarias() == null)
            itemCompra.setLuminarias(new ArrayList<Luminaria>());

        if (itemCompraDTO.luminarias().size() > 0){
            List<Luminaria> luminarias = itemCompra.getLuminarias();

            for (int i = 0; i <= itemCompraDTO.luminarias().size(); i++) {
                int index = 0;
                Luminaria luminaria = luminariaRepository.findById(itemCompraDTO.luminarias().get(index));

                if (index == 0)
                    itemCompra.setValorTotal(luminaria.getValor().doubleValue());

                itemCompra.setValorTotal(itemCompra.getValorTotal() + luminaria.getValor().doubleValue());


                luminarias.add(luminaria);

                index++;
            }

            itemCompra.setLuminarias(luminarias);
        }

        itemCompraRepository.persist(itemCompra);

        return new ItemCompraResponceDTO(itemCompra) ;
    }

    @Override
    public ItemCompraResponceDTO update(Long id, ItemCompraDTO itemCompraDTO) {
        ItemCompra itemCompra = itemCompraRepository.findById(id);

        if (itemCompra == null){
            throw new IllegalArgumentException("ItemCompra não encontrado");
        } else if (itemCompra.getLivros() == null) {
            itemCompra.setLivros(new ArrayList<Livro>());
        }

        if (itemCompraDTO.livros().size() > 0) {

            // List<Livro> livros = itemCompra.getLivros();

            for (int i = 0; i <= itemCompraDTO.livros().size(); i++) {
                int index = 0;
                Livro livro = livroRepository.findById(itemCompraDTO.livros().get(index));

                if (index == 0)
                    itemCompra.setValorTotal(livro.getValor().doubleValue());

                itemCompra.setValorTotal(itemCompra.getValorTotal() + livro.getValor().doubleValue());

                itemCompra.getLivros().add(livro);

                index++;
            }

            // itemCompra.setLivros(livros);
        }
        if (itemCompra.getLuminarias() == null)
            itemCompra.setLuminarias(new ArrayList<Luminaria>());

        if (itemCompraDTO.luminarias().size() > 0){
            List<Luminaria> luminarias = itemCompra.getLuminarias();

            for (int i = 0; i <= itemCompraDTO.luminarias().size(); i++) {
                int index = 0;
                Luminaria luminaria = luminariaRepository.findById(itemCompraDTO.luminarias().get(index));

                if (index == 0)
                    itemCompra.setValorTotal(luminaria.getValor().doubleValue());

                itemCompra.setValorTotal(itemCompra.getValorTotal() + luminaria.getValor().doubleValue());


                luminarias.add(luminaria);

                index++;
            }

            itemCompra.setLuminarias(luminarias);
        }

        itemCompraRepository.persist(itemCompra);

        return new ItemCompraResponceDTO(itemCompra) ;
    }

    @Override
    public void delete(Long id) {
        itemCompraRepository.deleteById(id);
    }
}
