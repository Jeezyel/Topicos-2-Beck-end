package br.unitins.resouce;

import br.unitins.DTO.*;
import br.unitins.aplication.Result;
import br.unitins.form.ConsultaImageForm;
import br.unitins.service.FileService;
import br.unitins.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.util.List;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResouce {
    @Inject
    UsuarioService usuarioService;

    @Inject
    FileService fileService;


    private static final Logger LOG = Logger.getLogger(UsuarioResouce.class);

    @GET
    @Path("/getAll/")
    public List<UsuarioResponceDTO> getAll(@QueryParam("page") @DefaultValue("0") int page ,@QueryParam("pageSize")  @DefaultValue("10") int pageSize) {
        LOG.info("Buscando todos os usuarios.");
        LOG.debug("Debug de busca de lista de usuarios.");
        return usuarioService.getAll(page,pageSize);
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

    @POST
    @Path("/insertsimpeles")
    @Transactional
    public Response toCreateSimples (UsuarioSimplesDTO usuarioSimplesDTO) {
        LOG.info("Inserindo um usuario.");
        try {
            UsuarioResponceSimplesDTO usuarioSimples = usuarioService.create(usuarioSimplesDTO);
            return Response.status(Status.CREATED).entity(usuarioSimples).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de usuario.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")
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

//    @PUT
//    @Path("/alterarSenha/{id}/{senhaantiga}/{novasenha}")
//    @Transactional
//    public Response alterarSenha (@PathParam("id") Long id, @PathParam("senhaantiga") String senhaantiga, @PathParam("novasenha") String novasenha) {
//        LOG.info("Atualiza a senha do usuario.");
//        try {
//            Boolean alteradoSenha = usuarioService.alterarSenha(id, senhaantiga, novasenha);
//            if (alteradoSenha)
//                return Response.ok().build();
//            else
//                return Response.status(Status.BAD_REQUEST).build();
//        } catch (ConstraintViolationException e) {
//            Result result = new Result(e.getConstraintViolations());
//            LOG.debug("Debug de updat de usuario.");
//            LOG.error("ERRO: ", e);
//            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
//        }
//    }

    @PUT
    @Path("/alterarSenha/{nome}/{senhaantiga}/{novasenha}")
    @Transactional
    public Response alterarSenha (@PathParam("nome") String nome, @PathParam("senhaantiga") String senhaantiga, @PathParam("novasenha") String novasenha) {
        LOG.info("Atualiza a senha do usuario.");
        try {
            Boolean alteradoSenha = usuarioService.alterarSenha(nome, senhaantiga, novasenha);
            if (alteradoSenha)
                return Response.ok().build();
            else
                return Response.status(Status.BAD_REQUEST).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de updat de usuario.");
            LOG.error("ERRO: ", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
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
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        LOG.info("deleta um usuario.");
        usuarioService.delete(id);
        LOG.debug("Debug de deletar usuarios.");
        return Response.status(Status.NO_CONTENT).build();
    }


    @PATCH
    @Path("/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ConsultaImageForm form) {
        LOG.info("nome imagem: "+form.getNomeImagem());
        System.out.println("nome imagem: "+form.getNomeImagem());

        fileService.salvar(form.getId(), form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        System.out.println(nomeImagem);
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }


}
