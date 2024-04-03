package br.unitins.resouce;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.ContatoService;
import br.unitins.service.CorService;
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
public class CorResouce {
    @Inject
    CorService corService;
    private static final Logger LOG = Logger.getLogger(CorResouce.class);

    @GET
    @Path("/getAll")
    public List<CorResponceDTO> getAll() {
        return corService.getAll();
    }

    @GET
    @Path("/search/{id}")
    public CorResponceDTO findById(@PathParam("id") Long id) {
        return corService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(CorDTO corDTO) {
        try {
            CorResponceDTO contato = corService.create(corDTO);
            return Response.status(Status.CREATED).entity(contato).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        corService.delete(id);
    }


    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, CorDTO corDTO) {
        LOG.info("Atualiza um contato.");
        try {
            corService.update(id, corDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }





}
