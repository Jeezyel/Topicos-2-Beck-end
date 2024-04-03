package br.unitins.resouce;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.ContatoService;
import br.unitins.service.EnderecoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/contato")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContatoResouce {
    @Inject
    ContatoService contatoService;
    private static final Logger LOG = Logger.getLogger(ContatoResouce.class);

    @GET
    @Path("/getAll")
    public List<ContatoResponceDTO> getAll() {
        LOG.info("Buscando todos os contato.");
        LOG.debug("Debug de busca de lista de contatos.");
        return contatoService.getAll();
    }

    @GET
    @Path("/search/{id}")
    public ContatoResponceDTO findById(@PathParam("id") Long id) {
        LOG.info("Buscando ID de contato.");
        return contatoService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(ContatoDTO contatoDTO) {
        LOG.info("Inserindo um contato.");
        try {
            ContatoResponceDTO contato = contatoService.create(contatoDTO);
            return Response.status(Status.CREATED).entity(contato).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, ContatoDTO contatoDTO) {
        LOG.info("Atualiza um contato.");
        try {
            contatoService.update(id, contatoDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @Path("/count")
    public long count() {
        LOG.info("Conta contato.");
        return contatoService.count();
    }

    @GET
    @Path("/search/{email}")
    public List<ContatoResponceDTO> search(@PathParam("email") String email) {
        LOG.info("Busca nome de contato.");
        return contatoService.findByEmail(email);
    }


}
