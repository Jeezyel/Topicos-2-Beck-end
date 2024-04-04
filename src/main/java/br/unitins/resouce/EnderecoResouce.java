package br.unitins.resouce;

import br.unitins.DTO.EnderecoDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.EstadoDTO;
import br.unitins.DTO.EstadoResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.EnderecoService;
import br.unitins.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResouce {
    @Inject
    EnderecoService enderecoService;
    private static final Logger LOG = Logger.getLogger(EnderecoResouce.class);

    @GET
    @Path("/getAll/{page}/{pageSize}")
    public List<EnderecoResponceDTO> getAll(@PathParam("page") int page ,@PathParam("pageSize") int pageSize) {
        LOG.info("Buscando todos os estados.");
        LOG.debug("Debug de busca de lista de estados.");
        return enderecoService.getAll(page,pageSize);
    }

    @GET
    @Path("/search/{id}")
    public EnderecoResponceDTO findById(@PathParam("id") Long id) {
        LOG.info("Buscando ID de estados.");
        return enderecoService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(EnderecoDTO enderecoDTO) {
        LOG.info("Inserindo um endereco.");
        try {
            EnderecoResponceDTO endereco = enderecoService.create(enderecoDTO);
            return Response.status(Status.CREATED).entity(endereco).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de endereco.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, EnderecoDTO enderecoDTO) {
        LOG.info("Atualiza um estado.");
        try {
            enderecoService.update(id, enderecoDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de endereco.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @Path("/count")
    public long count() {
        LOG.info("Conta estados.");
        return enderecoService.count();
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @Transactional
    public void DeleteForId(@PathParam("Id") long id){
        enderecoService.delete(id);
    }


    @GET
    @Path("/search/{cep}")
    public List<EnderecoResponceDTO> search(@PathParam("cep") String cep) {
        LOG.info("Busca nome de estados.");
        return enderecoService.findByCep(cep);
    }


}
