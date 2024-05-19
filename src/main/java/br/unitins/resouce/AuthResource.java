package br.unitins.resouce;

import br.unitins.DTO.AuthUsuarioDTO;
import br.unitins.DTO.UsuarioResponceDTO;
import br.unitins.model.Usuario;
import br.unitins.service.HashService;
import br.unitins.service.TokenJwtService;
import br.unitins.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    TokenJwtService tokenService;

    @Inject
    JsonWebToken jwt;

    @POST
    public Response login(AuthUsuarioDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());

        Usuario usuario = usuarioService.findByUsernameAndSenha(authDTO.login(), hash);

        if (usuario == null) {
            return Response.status(Status.NO_CONTENT)
                    .entity("Usuario não encontrado").build();
        }
        return Response.ok()
                .header("Authorization", tokenService.generateJwt(usuario))
                .build();
    }
}
