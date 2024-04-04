package br.unitins.resouce;

import br.unitins.DTO.AutorDTO;
import br.unitins.DTO.AutorResponceDTO;
import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.AutorService;
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

@Path("/autor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorResouce {
    @Inject
    AutorService autorService;
    private static final Logger LOG = Logger.getLogger(AutorResouce.class);

    @GET
    @Path("/getAll")
    public List<AutorResponceDTO> getAll() {
        return autorService.getAll();
    }

    @GET
    @Path("/search/{id}")
    public AutorResponceDTO findById(@PathParam("id") Long id) {
        return autorService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(AutorDTO autorDTO) {
        try {
            AutorResponceDTO autor = autorService.create(autorDTO);
            return Response.status(Status.CREATED).entity(autor).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @Transactional
    public void DeleteForId(@PathParam("Id") long id){
        autorService.delete(id);
    }


    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, AutorDTO autorDTO) {
        LOG.info("Atualiza um contato.");
        try {
            autorService.update(id, autorDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }





}
