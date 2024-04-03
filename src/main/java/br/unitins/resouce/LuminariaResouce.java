package br.unitins.resouce;

import br.unitins.DTO.LuminariaDTO;
import br.unitins.DTO.LuminariaResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.LuminariaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/luminaria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LuminariaResouce {
    @Inject
    LuminariaService luminariaService;
    private static final Logger LOG = Logger.getLogger(LuminariaResouce.class);

    @GET
    @Path("/getAll")
    public List<LuminariaResponceDTO> getAll() {
        return luminariaService.getAll();
    }

    @GET
    @Path("/search/{id}")
    public LuminariaResponceDTO findById(@PathParam("id") Long id) {
        return luminariaService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(LuminariaDTO luminariaDTO) {
        try {
            LuminariaResponceDTO luminaria = luminariaService.create(luminariaDTO);
            return Response.status(Status.CREATED).entity(luminaria).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        luminariaService.delete(id);
    }


    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, LuminariaDTO luminariaDTO) {
        LOG.info("Atualiza um contato.");
        try {
            luminariaService.update(id, luminariaDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }





}
