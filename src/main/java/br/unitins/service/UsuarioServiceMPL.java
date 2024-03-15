package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.UsuarioDTO;
import br.unitins.DTO.UsuarioResponceDTO;
import br.unitins.model.Endereco;
import br.unitins.model.Usuario;
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
public class UsuarioServiceMPL implements UsuarioService{
    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponceDTO> getAll() {

        List<Usuario> list = usuarioRepository.listAll();
        return list.stream().map(UsuarioResponceDTO::new).collect(Collectors.toList());

    }

    @Override
    public UsuarioResponceDTO create(UsuarioDTO usuarioDTO) {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.nome());
        entity.setCpf(usuarioDTO.cpf());
        entity.setTelefone(usuarioDTO.Telefone());
        entity.setEndereco(enderecoRepository.findById(usuarioDTO.idEndereco()));
        entity.setLogin(usuarioDTO.login());
        entity.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);


    }

    @Override
    public UsuarioResponceDTO update(Long id, UsuarioDTO usuarioDTO) {
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);


        entity.setNome(usuarioDTO.nome());
        entity.setCpf(usuarioDTO.cpf());
        entity.setTelefone(usuarioDTO.Telefone());
        entity.setEndereco(enderecoRepository.findById(usuarioDTO.idEndereco()));
        entity.setLogin(usuarioDTO.login());
        entity.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);
    }

    @Override
    public UsuarioResponceDTO findById(long id) {
        return new UsuarioResponceDTO(usuarioRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponceDTO> findByNome(String nome) {

        List<Usuario> list = usuarioRepository.findByListaNome(nome);
        return list.stream().map(UsuarioResponceDTO::new).collect(Collectors.toList());
    }



    @Override
    public long count() {
        return usuarioRepository.count();
    }

    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
