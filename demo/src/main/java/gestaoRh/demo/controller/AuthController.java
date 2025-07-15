package gestaoRh.demo.controller;

import gestaoRh.demo.Security.JwtUtil;
import gestaoRh.demo.model.AuthResponse;
import gestaoRh.demo.model.LoginRequest;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthController {

    @POST
    @Path("/login")
    public Response login(LoginRequest request) {

        boolean autenticado = autenticaUsuario(request.getUsername(), request.getPassword());
        if (autenticado) {
            String token = JwtUtil.generateToken(request.getUsername());
            return Response.ok(new AuthResponse(token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private boolean autenticaUsuario(String username, String password) {
        return true;
    }
}