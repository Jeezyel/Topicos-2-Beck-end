package br.unitins.service;

import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.DTO.MarcaDTO;
import br.unitins.DTO.MarcaResponceDTO;
import br.unitins.model.Cor;
import br.unitins.model.Marca;
import br.unitins.repository.CorRepository;
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
public class MarcaServiceMPL implements MarcaService{
    @Inject
    MarcaRepository marcaRepository;


    @Inject
    Validator validator;


    @Override
    public List<MarcaResponceDTO> getAll() {

        List<Marca> list = marcaRepository.listAll();
        return list.stream().map(MarcaResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public MarcaResponceDTO create(MarcaDTO marcaDTO) {
        validar(marcaDTO);

        Marca entity = new Marca();

        entity.setNome(marcaDTO.nome());
        entity.setDescricao(marcaDTO.descircao());

        marcaRepository.persist(entity);

        return new MarcaResponceDTO(entity);


    }

    @Override
    public MarcaResponceDTO update(Long id, MarcaDTO marcaDTO) {
        validar(marcaDTO);

        Marca entity = marcaRepository.findById(id);

        entity.setNome(marcaDTO.nome());
        entity.setDescricao(marcaDTO.descircao());

        marcaRepository.persist(entity);

        return new MarcaResponceDTO(entity);
    }

    @Override
    public MarcaResponceDTO findById(long id) {
        return new MarcaResponceDTO(marcaRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }






    private void validar(MarcaDTO marcaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<MarcaDTO>> violations = validator.validate(marcaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
