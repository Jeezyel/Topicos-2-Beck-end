package br.unitins.resouce;

import br.unitins.DTO.*;
import br.unitins.aplication.Result;
import br.unitins.service.EstadoService;
import br.unitins.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResouce {
    @Inject
    UsuarioService usuarioService;
    private static final Logger LOG = Logger.getLogger(UsuarioResouce.class);

    @GET
    @Path("/getAll")
    public List<UsuarioResponceDTO> getAll() {
        LOG.info("Buscando todos os usuarios.");
        LOG.debug("Debug de busca de lista de usuarios.");
        return usuarioService.getAll();
    }

    @POST
    @Path("/insert")
    @Transactional
    public Response toCreate (UsuarioDTO usuarioDTO) {
        LOG.info("Inserindo um usuario.");
        try {
            UsuarioResponceDTO usuario = usuarioService.create(usuarioDTO);
            return Response.status(Status.CREATED).entity(usuario).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de usuario.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")/*
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    @Transactional
    public Response toUpdate (@PathParam("id") Long id, UsuarioDTO usuarioDTO) {
        LOG.info("Atualiza um usuario.");
        try {
            usuarioService.update(id, usuarioDTO);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de usuario.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<UsuarioResponceDTO> search(@PathParam("nome") String nome) {
        LOG.info("Busca nome de usuarios.");
        return usuarioService.findByNome(nome);
    }

    @GET
    @Path("/search/{id}")
    public UsuarioResponceDTO findById(@PathParam("id") Long id) {
        LOG.info("Buscando ID de usuario.");
        return usuarioService.findById(id);
    }

    @PATCH
    @Path("/addaddress/{idusuario}")
    public Response  addAddress (@PathParam("idusuario") Long idusuario, EnderecoDTO enderecoDTO){
        try {
            LOG.info("PEGANDO O RETORNO DO METODO ADDADDRESS ");
            UsuarioResponceDTO usuario = usuarioService.addAddress(idusuario,enderecoDTO);
            LOG.info("RETORNANDO SUCESSOR DO ADDADDRESS");
            return Response.status(Status.NO_CONTENT).build();

        }catch (ConstraintViolationException e){

            Result result = new Result(e.getConstraintViolations());
            LOG.info("RETORNANDO O ERRO DO ADDADDRESS");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PATCH
    @Path("/mainaddress/{idusuario}")
    public Response  mainAddress (@PathParam("idusuario") Long idusuario, String cep){
        try {
            LOG.info("PEGANDO O RETORNO DO METODO MAINADDRESS");
            UsuarioResponceDTO usuario = usuarioService.mainAddress(idusuario, cep);
            LOG.info("RETORNANDO SUCESSOR DO MAINADDRESS");
            return Response.status(Status.NO_CONTENT).build();

        }catch (ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            LOG.info("RETORNANDO O ERRO DO MAINADDRESS");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @GET
    @Path("/count")
    public long count() {
        LOG.info("Conta usuarios.");
        return usuarioService.count();
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        usuarioService.delete(id);
    }





}
