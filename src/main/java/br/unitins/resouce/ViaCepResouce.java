package br.unitins.resouce;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
import br.unitins.DTO.EnderecoResponceDTO;
import br.unitins.DTO.UsuarioResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.model.ViaCep;
import br.unitins.service.ContatoService;
import br.unitins.service.ViacepService;
import br.unitins.teste.EnderecoTeste;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Null;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/viacep")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViaCepResouce {
    @Inject
    ViacepService viacepService;
    private static final Logger LOG = Logger.getLogger(ViaCepResouce.class);



    @GET
    @Path("/{cep}")
    public ViaCep ViaCep (@PathParam("cep") String cep) {

        try {
            return viacepService.ViaCep(cep);
        }catch ( Exception e ){
            return null;
        }



    }

    @GET
    @Path("endereco/{cep}")
    public Response enderecoCep(@PathParam("cep") String cep) {

        LOG.info("Pegando o endereco pelo cep.");
        try {
            EnderecoResponceDTO enderecoResponceDTO = viacepService.enderecoCep(cep);
            return Response.ok(enderecoResponceDTO).status(Status.OK).build();
        } catch (Exception e) {
            Result result = new Result(e.getMessage());

            LOG.error("ERRO: " + e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
        }



    }


}
