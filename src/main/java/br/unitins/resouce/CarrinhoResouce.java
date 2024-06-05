package br.unitins.resouce;

import br.unitins.DTO.*;
import br.unitins.aplication.Result;
import br.unitins.service.CarrinhoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/carrinho")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarrinhoResouce {

    private static final Logger LOG = Logger.getLogger(CarrinhoResouce.class);

    @Inject
    CarrinhoService carrinhoService;

    @GET
    @Path("/getAll/")
    public List<CarrinhoResponceDTO> getAll(@QueryParam("page") @DefaultValue("0") int page , @QueryParam("pageSize")  @DefaultValue("10") int pageSize) {
        LOG.info("Buscando todos os usuarios.");
        LOG.debug("Debug de busca de lista de usuarios.");
        return carrinhoService.getAll(page,pageSize);
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response toCreate (CarrinhoDTO carrinhoDTO) {
        LOG.info("Inserindo um carrinho.");
        try {
            CarrinhoResponceDTO carrinho = carrinhoService.create(carrinhoDTO);
            return Response.status(Response.Status.CREATED).entity(carrinho).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de carrinho.");
            return Response.status(Response.Status.NOT_FOUND).entity(result).build();
        }
    }

    @POST
    @Path("/finalizarcompra/{idCarrinho}")
    @Transactional
    public Response finalizarCompra (@PathParam("idCarrinho") Long idCarrinho, PagamentoDTO pagamentoDTO) {
        LOG.info("finalizando a compra.");
        try {
            CarrinhoResponceDTO carrinho = carrinhoService.finalizarCompra(idCarrinho,pagamentoDTO);
            return Response.status(Response.Status.CREATED).entity(carrinho).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("erro em finalizar compra." + e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{idCarrinho}")
    @Transactional
    public Response toUpdate (@PathParam("idCarrinho") Long idCarrinho, CarrinhoDTO carrinhoDTO) {
        LOG.info("Atualiza um carrinho.");
        try {
            carrinhoService.update(idCarrinho, carrinhoDTO);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de carrinho.");
            return Response.status(Response.Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/DeleteForId/{idCarrinho}")
    @Transactional
    public Response delete(@PathParam("idCarrinho") Long idCarrinho) {
        LOG.info("deleta um carrinho.");
        carrinhoService.delete(idCarrinho);
        LOG.debug("Debug de deletar carrinho.");
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        LOG.info("Conta carrinho.");
        return carrinhoService.count();
    }

    @GET
    @Path("/search/{idCarrinho}")
    public CarrinhoResponceDTO search(@PathParam("idCarrinho") long idCarrinho){
        return carrinhoService.findById(idCarrinho);

    }

}
