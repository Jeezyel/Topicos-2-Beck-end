package br.unitins.service;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.EstadoDTO;
import br.unitins.DTO.EstadoResponceDTO;
import br.unitins.model.Endereco;
import br.unitins.model.Estado;
import br.unitins.repository.EnderecoRepository;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.MunicipioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class EnderecoServiceMPL implements EnderecoService{
    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    Validator validator;

    @Override
    public List<EnderecoResponceDTO> getAll(int page , int pageSize) {
        List<Endereco> listAux = enderecoRepository.listAll();


        while (listAux.size() < (page + pageSize)){
            if (page < 1) {
                pageSize --;
            } else {
                page --;
            }

        }




        List<Endereco> list = listAux.subList(page,pageSize);
        return list.stream().map(EnderecoResponceDTO::new).collect(Collectors.toList());

    }

    @Override
    public EnderecoResponceDTO create(EnderecoDTO enderecoDTO) {
        validar(enderecoDTO);

        Endereco entity = new Endereco();
        entity.setCep(enderecoDTO.cep());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setBairro(enderecoDTO.bairro());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        enderecoRepository.persist(entity);

        return new EnderecoResponceDTO(entity);


    }

    @Override
    public EnderecoResponceDTO update(Long id, EnderecoDTO enderecoDTO) {
        validar(enderecoDTO);

        Endereco entity = enderecoRepository.findById(id);


        entity.setCep(enderecoDTO.cep());
        entity.setLogradouro(enderecoDTO.logradouro());
        entity.setComplemento(enderecoDTO.complemento());
        entity.setBairro(enderecoDTO.bairro());
        entity.setMunicipio(municipioRepository.findById(enderecoDTO.idMunicipio()));

        enderecoRepository.persist(entity);

        return new EnderecoResponceDTO(entity);
    }

    @Override
    public EnderecoResponceDTO findById(long id) {
        return new EnderecoResponceDTO(enderecoRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    @Override
    public List<EnderecoResponceDTO> findByCep(String cep) {

        List<Endereco> list = enderecoRepository.findByListaCep(cep);
        return list.stream().map(EnderecoResponceDTO::new).collect(Collectors.toList());
    }



    @Override
    public long count() {
        return enderecoRepository.count();
    }

    private void validar(EnderecoDTO enderecoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EnderecoDTO>> violations = validator.validate(enderecoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
