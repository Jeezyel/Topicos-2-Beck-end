package br.unitins.service;

import br.unitins.DTO.*;
import br.unitins.model.Carrinho;
import br.unitins.model.ItemCompra;
import br.unitins.model.Livro;
import br.unitins.model.Luminaria;
import br.unitins.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.jboss.logging.Logger;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CarrinhoServiceMPL implements CarrinhoService{

    private static final Logger LOG = Logger.getLogger(CarrinhoServiceMPL.class);

    @Inject
    CarrinhoRepository carrinhoRepository;

    @Inject
    PagamentoService pagamentoService;

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    Validator validator;

    @Inject
    ItemCompraService itemCompraService;

    @Inject
    UsuarioRepository usuarioRepository;


    @Override
    public List<CarrinhoResponceDTO> getAll(int page, int pageSize) {
        List<Carrinho> list = carrinhoRepository.findAll().page(page,pageSize).list();
        return list.stream().map(CarrinhoResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public CarrinhoResponceDTO create(CarrinhoDTO carrinhoDTO) {

        validar(carrinhoDTO);

        Carrinho carrinho = new Carrinho();


        carrinho.setDataCriaçãoCarrinho(LocalDateTime.now());
        carrinho.setItemCompra(itemCompraService.createItemCompra(carrinhoDTO.itemCompra()));
        carrinho.setUsuario(usuarioRepository.findById(carrinhoDTO.usuario()));


        carrinhoRepository.persist(carrinho);


        return new CarrinhoResponceDTO(carrinho);
    }

    @Override
    public CarrinhoResponceDTO update(Long idCarrinho, CarrinhoDTO carrinhoDTO) {
        validar(carrinhoDTO);

        Carrinho carrinho = carrinhoRepository.findById(idCarrinho);

        carrinho.setItemCompra(itemCompraService.updateItemCompra(idCarrinho, carrinhoDTO.itemCompra()));
        carrinho.setUsuario(usuarioRepository.findById(carrinhoDTO.usuario()));


        carrinhoRepository.persist(carrinho);


        return new CarrinhoResponceDTO(carrinho);
    }

    @Override
    public CarrinhoResponceDTO AddCarrinho(Long idCarrinho, ItemCompraDTO itemCompraDTO) {
        validar(itemCompraDTO);

        Carrinho carrinho = carrinhoRepository.findById(idCarrinho);

        carrinho.setItemCompra(itemCompraService.updateItemCompra(idCarrinho,itemCompraDTO));

        carrinhoRepository.persist(carrinho);

        return new CarrinhoResponceDTO(carrinho);
    }

    @Override
    public CarrinhoResponceDTO finalizarCompra(Long idCarrinho, PagamentoDTO pagamentoDTO) {
        return pagamentoService.finalizarCompra(idCarrinho,pagamentoDTO);
    }

    @Override
    public void delete(Long id) {
        carrinhoRepository.deleteById(id);
    }

    @Override
    public CarrinhoResponceDTO findById(long id) {
        return new CarrinhoResponceDTO(carrinhoRepository.findById(id));
    }

    @Override
    public long count() {
        return carrinhoRepository.count();
    }

//    private ItemCompra createItemCompra( ItemCompraDTO itemCompraDTO) {
//        ItemCompra itemCompra = new ItemCompra();
//
//        if (itemCompra == null){
//            throw new IllegalArgumentException("ItemCompra não pode ser nulo");
//        } else if (itemCompra.getLivros() == null) {
//            itemCompra.setLivros(new ArrayList<Livro>());
//        }
//
//        if (itemCompraDTO.livros().size() > 0){
//
//            // List<Livro> livros = itemCompra.getLivros();
//
//            for (int i = 0; i <= itemCompraDTO.livros().size(); i++) {
//                int index = 0;
//                Livro livro = livroRepository.findById(itemCompraDTO.livros().get(index));
//
//                itemCompra.getLivros().add(livro);
//
//                index++;
//            }
//
//           // itemCompra.setLivros(livros);
//        }
//
//        if (itemCompra.getLuminarias() == null)
//            itemCompra.setLuminarias(new ArrayList<Luminaria>());
//
//        if (itemCompraDTO.luminarias().size() > 0){
//            List<Luminaria> luminarias = itemCompra.getLuminarias();
//
//            for (int i = 0; i <= itemCompraDTO.luminarias().size(); i++) {
//                int index = 0;
//                Luminaria luminaria = luminariaRepository.findById(itemCompraDTO.luminarias().get(index));
//
//                luminarias.add(luminaria);
//
//                index++;
//            }
//
//            itemCompra.setLuminarias(luminarias);
//        }
//
//
//        return itemCompra ;
//    }

    private void validar(CarrinhoDTO carrinhoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CarrinhoDTO>> violations = validator.validate(carrinhoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    private void validar(ItemCompraDTO itemCompraDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ItemCompraDTO>> violations = validator.validate(itemCompraDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
