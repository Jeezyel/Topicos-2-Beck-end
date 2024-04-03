package br.unitins.service;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.model.Contato;
import br.unitins.model.Cor;
import br.unitins.repository.ContatoRepository;
import br.unitins.repository.CorRepository;
import br.unitins.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CorServiceMPL implements CorService{
    @Inject
    CorRepository corRepository;


    @Inject
    Validator validator;


    @Override
    public List<CorResponceDTO> getAll() {

        List<Cor> list = corRepository.listAll();
        return list.stream().map(CorResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public CorResponceDTO create(CorDTO corDTO) {
        validar(corDTO);

        Cor entity = new Cor();

        entity.setCorRgb(corDTO.corRgb());
        entity.setDescricao(corDTO.descircao());

        corRepository.persist(entity);

        return new CorResponceDTO(entity);


    }

    @Override
    public CorResponceDTO update(Long id, CorDTO corDTO) {
        validar(corDTO);

        Cor entity = corRepository.findById(id);
        entity.setCorRgb(corDTO.corRgb());
        entity.setDescricao(corDTO.descircao());

        corRepository.persist(entity);

        return new CorResponceDTO(entity);
    }

    @Override
    public CorResponceDTO findById(long id) {
        return new CorResponceDTO(corRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        corRepository.deleteById(id);
    }






    private void validar(CorDTO corDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CorDTO>> violations = validator.validate(corDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
