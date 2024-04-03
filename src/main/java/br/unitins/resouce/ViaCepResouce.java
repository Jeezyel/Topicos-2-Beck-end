package br.unitins.resouce;

import br.unitins.DTO.ContatoDTO;
import br.unitins.DTO.ContatoResponceDTO;
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
    @Path("/search/{cep}")
    public ViaCep ViaCep (@PathParam("cep") String cep) {

        try {
            return viacepService.ViaCep(cep);
        }catch ( Exception e ){
            return null;
        }



    }


}
