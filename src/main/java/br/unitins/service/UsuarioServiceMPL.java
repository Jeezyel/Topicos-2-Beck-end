package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.UsuarioDTO;
import br.unitins.DTO.UsuarioResponceDTO;
import br.unitins.model.*;
import br.unitins.repository.ContatoRepository;
import br.unitins.repository.EnderecoRepository;
import br.unitins.repository.MunicipioRepository;
import br.unitins.repository.UsuarioRepository;
import io.quarkus.arc.ArcUndeclaredThrowableException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioServiceMPL implements UsuarioService{

    private static final Logger LOG = Logger.getLogger(UsuarioServiceMPL.class);
    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    ContatoRepository contatoRepository;

    @Inject
    EnderecoRepository enderecoRepository;


    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponceDTO> getAll(int page , int pageSize) {
        List<Usuario> list = usuarioRepository.findAll().page(page,pageSize).list();
        return list.stream().map(UsuarioResponceDTO::new).collect(Collectors.toList());

    }

    @Override
    public UsuarioResponceDTO create(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.nome());
        entity.setDataNacimento(usuarioDTO.dataNacimento());
        entity.setCpf(usuarioDTO.cpf());
        entity.setContato(contatoRepository.findById(usuarioDTO.contato()));
        entity.setEnderecoPrincipal(usuarioDTO.enderecos().get(0));
        entity.setTodosEndereco(usuarioDTO.enderecos());
        entity.setLogin(usuarioDTO.login());
        entity.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);


    }

    @Override
    public UsuarioResponceDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException{
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);


        entity.setNome(usuarioDTO.nome());
        entity.setCpf(usuarioDTO.cpf());
        entity.setContato(contatoRepository.findById(usuarioDTO.contato()));
        entity.setEnderecoPrincipal(usuarioDTO.enderecos().get(0));
        entity.setTodosEndereco(usuarioDTO.enderecos());
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
    public UsuarioResponceDTO addAddress(long idUsuario, EnderecoDTO enderecoDTO) throws ConstraintViolationException{

        Usuario entity = usuarioRepository.findById(idUsuario);

        Endereco endereco = new Endereco();

        endereco.setCep(enderecoDTO.cep());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        entity.getTodosEndereco().add(endereco);

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);
    }

    @Override
    public UsuarioResponceDTO mainAddress(long idUsuario, String CEP) throws ConstraintViolationException{

        Usuario entity = usuarioRepository.findById(idUsuario);

        Endereco endereco = enderecoRepository.findByCep(CEP);


        entity.setEnderecoPrincipal(endereco);

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
        try {
            usuarioRepository.deleteById(id);
        }
        catch (ArcUndeclaredThrowableException e){
            LOG.info("erro, tem uma autor Veiculado a essa usuario ");
            LOG.error("erro, tem uma autor Veiculado a essa usuario ", e );
        }
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

    @Override
    public Usuario findByUsernameAndSenha(String login, String senha) {

        Usuario entity = usuarioRepository.findByUsernameAndSenha(login, senha).firstResult();
        return entity;
    }
}
