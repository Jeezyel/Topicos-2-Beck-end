package br.unitins.service;

import br.unitins.DTO.LuminariaDTO;
import br.unitins.DTO.LuminariaResponceDTO;
import br.unitins.model.Luminaria;
import br.unitins.repository.LuminariaRepository;
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
    Validator validator;


    @Override
    public List<LuminariaResponceDTO> getAll() {

        List<Luminaria> list = luminariaRepository.listAll();
        return list.stream().map(LuminariaResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public LuminariaResponceDTO create(LuminariaDTO luminariaDTO) {
        validar(luminariaDTO);

        Luminaria entity = new Luminaria();

        entity.setEstilo(luminariaDTO.estilo());
        entity.setTipoDeFonteDeLuz(luminariaDTO.tipoDeFonteDeLuz());
        entity.setCores(luminariaDTO.cores());
        entity.setMarcas(luminariaDTO.marcas());

        luminariaRepository.persist(entity);

        return new LuminariaResponceDTO(entity);


    }

    @Override
    public LuminariaResponceDTO update(Long id, LuminariaDTO luminariaDTO) {
        validar(luminariaDTO);

        Luminaria entity = luminariaRepository.findById(id);

        entity.setEstilo(luminariaDTO.estilo());
        entity.setTipoDeFonteDeLuz(luminariaDTO.tipoDeFonteDeLuz());
        entity.setCores(luminariaDTO.cores());
        entity.setMarcas(luminariaDTO.marcas());

        luminariaRepository.persist(entity);

        return new LuminariaResponceDTO(entity);
    }

    @Override
    public LuminariaResponceDTO findById(long id) {
        return new LuminariaResponceDTO(luminariaRepository.findById(id));
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
