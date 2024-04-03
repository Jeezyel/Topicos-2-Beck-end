package br.unitins.resouce;

import br.unitins.DTO.CorDTO;
import br.unitins.DTO.CorResponceDTO;
import br.unitins.DTO.MarcaDTO;
import br.unitins.DTO.MarcaResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.MarcaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/marca")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaResouce {
    @Inject
    MarcaService marcaService;
    private static final Logger LOG = Logger.getLogger(MarcaResouce.class);

    @GET
    @Path("/getAll")
    public List<MarcaResponceDTO> getAll() {
        return marcaService.getAll();
    }

    @GET
    @Path("/search/{id}")
    public MarcaResponceDTO findById(@PathParam("id") Long id) {
        return marcaService.findById(id);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response insert(MarcaDTO marcaDTO) {
        try {
            MarcaResponceDTO marca = marcaService.create(marcaDTO);
            return Response.status(Status.CREATED).entity(marca).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        marcaService.delete(id);
    }


    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response update(@PathParam("id") Long id, MarcaDTO marcaDTO) {
        LOG.info("Atualiza um contato.");
        try {
            marcaService.update(id, marcaDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de contato.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }





}
