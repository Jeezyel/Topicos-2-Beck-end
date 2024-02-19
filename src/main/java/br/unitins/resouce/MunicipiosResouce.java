package br.unitins.resouce;
import br.unitins.DTO.MunicipiosDTO;
import br.unitins.DTO.MunicipiosResponceDTO;
import br.unitins.service.MunicipioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.aplication.Result;

import java.util.List;


@Path("/municipios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MunicipiosResouce {

    private static final Logger LOG = Logger.getLogger(MunicipiosResouce.class);
    @Inject
    MunicipioService municipioService;

    @GET
    @Path("/getAll")
    public List<MunicipiosResponceDTO> getAll() {
        LOG.info("buscando todos os municipios." );
        return municipioService.getAll();
    }

    @POST
    @Path("/insert")
    public Response insert(MunicipiosDTO dto) {

        LOG.infof("inserindo : %s ." , dto.nome());
        try {
            MunicipiosResponceDTO municipio = municipioService.create(dto);
            return Response.status(Status.CREATED).entity(municipio).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    public Response update(@PathParam("id") Long id, MunicipiosDTO dto) {
        try {
            MunicipiosResponceDTO municipio = municipioService.update(id, dto);
            return Response.ok(municipio).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        municipioService.delete(id);
    }


    @GET
    @Path("/count")
    public long count(){
        return municipioService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<MunicipiosResponceDTO> search(@PathParam("nome") String nome){
        return municipioService.findByNome(nome);

    }

}
