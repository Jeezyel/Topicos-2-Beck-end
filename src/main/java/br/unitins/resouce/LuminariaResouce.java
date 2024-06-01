package br.unitins.resouce;

import br.unitins.DTO.LuminariaDTO;
import br.unitins.DTO.LuminariaResponceDTO;
import br.unitins.aplication.Result;
import br.unitins.form.ConsultaImageForm;
import br.unitins.service.FileService;
import br.unitins.service.LuminariaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;


@Path("/luminaria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LuminariaResouce {
    @Inject
    LuminariaService luminariaService;

    @Inject
    FileService fileService;
    private static final Logger LOG = Logger.getLogger(LuminariaResouce.class);

    @GET
    @Path("/getAll/")
    public Response getAll(@QueryParam("page") @DefaultValue("0") int page ,@QueryParam("pageSize")  @DefaultValue("10") int pageSize) {
        return Response.ok(luminariaService.getAll(page,pageSize)).build();
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
    @Transactional
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

    @GET
    @Path("/count")
    public long count(){
        return luminariaService.count();
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
        Response.ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }





}
