package br.unitins.service;

import br.unitins.DTO.LuminariaDTO;
import br.unitins.DTO.LuminariaResponceDTO;
import br.unitins.model.Autor;
import br.unitins.model.Luminaria;
import br.unitins.repository.CorRepository;
import br.unitins.repository.LuminariaRepository;
import br.unitins.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class LuminariaServiceMPL implements LuminariaService{
    @Inject
    LuminariaRepository luminariaRepository;

    @Inject
    CorRepository corRepository;
    @Inject
    MarcaRepository marcaRepository;
    @Inject
    Validator validator;


    @Override
    public List<LuminariaResponceDTO> getAll(int page , int pageSize) {

        List<Luminaria> list = luminariaRepository.findAll().page(page, pageSize).list();
        return list.stream().map(LuminariaResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public LuminariaResponceDTO create(LuminariaDTO luminariaDTO) {
        validar(luminariaDTO);

        Luminaria entity = new Luminaria();

        entity.setEstilo(luminariaDTO.estilo());
        entity.setTipoDeFonteDeLuz(luminariaDTO.tipoDeFonteDeLuz());
        entity.setCor(corRepository.findById(luminariaDTO.cor()));
        entity.setMarca(marcaRepository.findById(luminariaDTO.marca()));
        entity.setDescricao(luminariaDTO.descricao());
        entity.setValor(luminariaDTO.valor());

        luminariaRepository.persist(entity);

        return new LuminariaResponceDTO(entity);


    }

    @Override
    public LuminariaResponceDTO update(Long id, LuminariaDTO luminariaDTO) {
        validar(luminariaDTO);

        Luminaria entity = luminariaRepository.findById(id);

        entity.setEstilo(luminariaDTO.estilo());
        entity.setTipoDeFonteDeLuz(luminariaDTO.tipoDeFonteDeLuz());
        entity.setCor(corRepository.findById(luminariaDTO.cor()));
        entity.setMarca(marcaRepository.findById(luminariaDTO.marca()));
        entity.setDescricao(luminariaDTO.descricao());
        entity.setValor(luminariaDTO.valor());

        luminariaRepository.persist(entity);

        return new LuminariaResponceDTO(entity);
    }

    @Override
    public LuminariaResponceDTO findById(long id) {
        return new LuminariaResponceDTO(luminariaRepository.findById(id));
    }

    @Override
    public long count() {
        return luminariaRepository.count();
    }

    @Override
    public void delete(Long id) {
        luminariaRepository.deleteById(id);
    }






    private void validar(LuminariaDTO luminariaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<LuminariaDTO>> violations = validator.validate(luminariaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
