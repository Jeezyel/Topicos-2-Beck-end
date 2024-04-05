package br.unitins.service;

import br.unitins.DTO.*;
import br.unitins.model.Autor;
import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Estado;
import br.unitins.repository.ContatoRepository;
import br.unitins.repository.EnderecoRepository;
import br.unitins.repository.MunicipioRepository;
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
public class ContatoServiceMPL implements ContatoService{
    @Inject
    ContatoRepository contatoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;


    @Override
    public List<ContatoResponceDTO> getAll() {

        List<Contato> list = contatoRepository.listAll();
        return list.stream().map(ContatoResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public ContatoResponceDTO create(ContatoDTO contatoDTO) {
        validar(contatoDTO);

        Contato entity = new Contato();

        entity.setTelefone(contatoDTO.telefones());
        entity.setEmail(contatoDTO.email());

        contatoRepository.persist(entity);

        return new ContatoResponceDTO(entity);


    }

    @Override
    public ContatoResponceDTO update(Long id, ContatoDTO contatoDTO) {
        validar(contatoDTO);

        Contato entity = contatoRepository.findById(id);

        entity.setTelefone(contatoDTO.telefones());
        entity.setEmail(contatoDTO.email());

        contatoRepository.persist(entity);

        return new ContatoResponceDTO(entity);
    }

    @Override
    public ContatoResponceDTO findById(long id) {
        return new ContatoResponceDTO(contatoRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public List<ContatoResponceDTO> findByEmail(String email) {

        List<Contato> list = contatoRepository.findByEmail(email);
        return list.stream().map(ContatoResponceDTO::new).collect(Collectors.toList());
    }



    @Override
    public long count() {
        return contatoRepository.count();
    }

    private void validar(ContatoDTO contatoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ContatoDTO>> violations = validator.validate(contatoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
