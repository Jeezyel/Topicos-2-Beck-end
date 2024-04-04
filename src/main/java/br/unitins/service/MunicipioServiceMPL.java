package br.unitins.service;
import br.unitins.DTO.MunicipiosDTO;
import br.unitins.DTO.MunicipiosResponceDTO;
import br.unitins.model.Estado;
import br.unitins.model.Municipio;
import br.unitins.model.Usuario;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.MunicipioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolationException;

import jakarta.transaction.Transactional;

import java.util.stream.Collectors;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class MunicipioServiceMPL implements MunicipioService{
    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Inject
    Validator validator;

    @Override
    public List<MunicipiosResponceDTO> getAll(int page , int pageSize) {
        List<Municipio> listAux = municipioRepository.listAll();


        while (listAux.size() < (page + pageSize)){
            if (page < 1) {
                pageSize --;
            } else {
                page --;
            }

        }




        List<Municipio> list = listAux.subList(page,pageSize);
        return list.stream().map(MunicipiosResponceDTO::new).collect(Collectors.toList());
    }



    @Override
    @Transactional
    public MunicipiosResponceDTO create(MunicipiosDTO municipioDTO) throws ConstraintViolationException{
        validar(municipioDTO);

        var entity = new Municipio();
        entity.setNome(municipioDTO.nome());

        entity.setEstado(new Estado());
        entity.getEstado().setId(municipioDTO.idEstado());

        municipioRepository.persist(entity);

        return new MunicipiosResponceDTO(entity);

    }

    @Override
    @Transactional
    public MunicipiosResponceDTO update(Long id, MunicipiosDTO municipioDTO) throws ConstraintViolationException{
        validar(municipioDTO);

        Municipio entity = municipioRepository.findById(id);


        entity.setNome(municipioDTO.nome());
        entity.setEstado(estadoRepository.findById(municipioDTO.idEstado()));

        return new MunicipiosResponceDTO(entity);
    }

    @Override
    public void delete(Long id) {
        municipioRepository.deleteById(id);
    }

    @Override
    public List<MunicipiosResponceDTO> findByNome(String nome) {
        List<Municipio> list = municipioRepository.findByNome(nome);
        return list.stream().map(MunicipiosResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return municipioRepository.count();
    }

    private void validar(MunicipiosDTO municipioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<MunicipiosDTO>> violations = validator.validate(municipioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}
