package br.unitins.service;

import br.unitins.DTO.*;
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
    HashService hashService;

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
        entity.setSenha(hashService.getHashSenha(usuarioDTO.senha()));

        usuarioRepository.persist(entity);

        return new UsuarioResponceDTO(entity);


    }

    @Override
    public UsuarioResponceSimplesDTO create(UsuarioSimplesDTO usuarioSimplesDTO) {
        validar(usuarioSimplesDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioSimplesDTO.nome());
        entity.setDataNacimento(usuarioSimplesDTO.dataNacimento());
        entity.setCpf(usuarioSimplesDTO.cpf());
        entity.setCep(usuarioSimplesDTO.cep());
        //login ou email para fezer o login
        entity.setLogin(usuarioSimplesDTO.email());
        entity.setSenha(hashService.getHashSenha(usuarioSimplesDTO.senha()));

        usuarioRepository.persist(entity);

        return new UsuarioResponceSimplesDTO(entity);
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
    public Boolean alterarSenha(Long id, String senhaAntiga, String novaSenha) throws ConstraintViolationException {
        Usuario entity = usuarioRepository.findById(id);

        try {

            LOG.error("Validando a senha");
            if ( entity.getSenha().equals(hashService.getHashSenha(senhaAntiga))){
                entity.setSenha(hashService.getHashSenha(novaSenha));
                LOG.info("salvando com a senha nova ");
                usuarioRepository.persist(entity);
                return true;
            }else {
                LOG.info("salvando com a senha senha antiga ");
                usuarioRepository.persist(entity);
                return false;
            }

        }catch (Exception e){
            LOG.error("ERRO NÃO IDENTIFICADO", e);
            return false;
        }


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

    private void validar(UsuarioSimplesDTO usuarioSimplesDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioSimplesDTO>> violations = validator.validate(usuarioSimplesDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    @Override
    public Usuario findByUsernameAndSenha(String login, String senha) {

        Usuario entity = usuarioRepository.findByUsernameAndSenha(login, senha).firstResult();
        return entity;
    }
}
