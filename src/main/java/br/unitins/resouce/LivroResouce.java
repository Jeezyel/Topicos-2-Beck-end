package br.unitins.resouce;

import br.unitins.DTO.LivroDTO;
import br.unitins.DTO.LivroResponceDTO;
import br.unitins.DTO.MunicipiosDTO;
import br.unitins.DTO.MunicipiosResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.service.LivroService;
import br.unitins.service.MunicipioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;


@Path("/Livro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroResouce {

    private static final Logger LOG = Logger.getLogger(LivroResouce.class);
    @Inject
    LivroService livroService;

    @GET
    @Path("/getAll")
    public List<LivroResponceDTO> getAll() {
        LOG.info("buscando todos os municipios." );
        return livroService.getAll();
    }

    @POST
    @Transactional
    @Path("/insert")
    public Response insert(LivroDTO livroDTO) {
        LOG.info("Inserindo um municipio.");
        try {
            LivroResponceDTO livro = livroService.create(livroDTO);
            return Response.status(Status.CREATED).entity(livro).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de livro.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, LivroDTO dto) {
        try {
            LivroResponceDTO livro = livroService.update(id, dto);
            return Response.ok(livro).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @Transactional
    public void DeleteForId(@PathParam("Id") long id){
        livroService.delete(id);
    }


    @GET
    @Path("/count")
    public long count(){
        return livroService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<LivroResponceDTO> search(@PathParam("nome") String nome){
        return livroService.findByNome(nome);

    }

}
