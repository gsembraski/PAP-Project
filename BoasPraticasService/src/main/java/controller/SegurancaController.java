package controller;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import viewModel.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("api/seguranca/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class SegurancaController {
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@Path("autenticacao")
	public Response Autenticacao(UsuarioLogarViewModel usuarioLogar) throws Exception {
		UsuarioViewModel usuarioVm = usuarioDAO.Logar(usuarioLogar);
		return Response.ok(GerarToken(usuarioVm.getEmail())).build();
	}
	
	private String GerarToken(String login){
		String compactJws = Jwts.builder()
				  .setSubject(login)
				  .signWith(SignatureAlgorithm.HS512, "teste")
				  .compact();
		return compactJws;
		
	}
}
