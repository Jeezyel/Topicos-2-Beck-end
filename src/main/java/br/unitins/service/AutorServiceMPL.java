package br.unitins.service;

import br.unitins.DTO.AutorDTO;
import br.unitins.DTO.AutorResponceDTO;
import br.unitins.model.Autor;
import br.unitins.repository.AutorRepository;
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
public class AutorServiceMPL implements AutorService{
    @Inject
    AutorRepository autorRepository;


    @Inject
    UsuarioRepository usuarioRepository;


    @Inject
    Validator validator;


    @Override
    public List<AutorResponceDTO> getAll() {

        List<Autor> list = autorRepository.listAll();
        return list.stream().map(AutorResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public AutorResponceDTO create(AutorDTO autorDTO) {
        validar(autorDTO);

        Autor entity = new Autor();

        entity.setUsuario(usuarioRepository.findById(autorDTO.idUsurio()));
        entity.setNomeArtistico(autorDTO.nomeAtistico());

        autorRepository.persist(entity);

        return new AutorResponceDTO(entity);


    }

    @Override
    public AutorResponceDTO update(Long id, AutorDTO autorDTO) {
        validar(autorDTO);

        Autor entity = autorRepository.findById(id);


        entity.setUsuario(usuarioRepository.findById(autorDTO.idUsurio()));
        entity.setNomeArtistico(autorDTO.nomeAtistico());

        autorRepository.persist(entity);

        return new AutorResponceDTO(entity);
    }

    @Override
    public AutorResponceDTO findById(long id) {
        return new AutorResponceDTO(autorRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        autorRepository.deleteById(id);
    }






    private void validar(AutorDTO autorDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<AutorDTO>> violations = validator.validate(autorDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
