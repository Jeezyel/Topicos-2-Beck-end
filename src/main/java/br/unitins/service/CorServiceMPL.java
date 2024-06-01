package br.unitins.service;

import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.model.Cor;
import br.unitins.repository.CorRepository;
import io.quarkus.arc.ArcUndeclaredThrowableException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CorServiceMPL implements CorService{


    private static final Logger LOG = Logger.getLogger(CorServiceMPL.class);
    @Inject
    CorRepository corRepository;


    @Inject
    Validator validator;


    @Override
    public List<CorResponceDTO> getAll(int page , int pageSize) {


        List<Cor> list = corRepository.findAll().page(page, pageSize).list();

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
    public long count() {
        return corRepository.count();
    }

    @Override
    public void delete(Long id) {

        try {
            if (id == null)
                throw new IllegalArgumentException("Número inválido");

            Cor cor = corRepository.findById(id);

            if (corRepository.isPersistent(cor)){
                corRepository.delete(cor);
            }else
                throw new NotFoundException("Nenhum usuario encontrado");

        }catch (ArcUndeclaredThrowableException e){
            LOG.info("erro, tem uma luminaria Vem colada a essa cor ");
            LOG.error("erro, tem uma luminaria Vem colada a essa cor ", e );

        }catch (Exception e){
            LOG.info("erro não identificado " );
            LOG.error("erro não identificado ", e );
        }


    }






    private void validar(CorDTO corDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CorDTO>> violations = validator.validate(corDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
}
