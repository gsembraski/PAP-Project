package controller;

import java.security.Key;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.*;
import entity.*;
import viewModel.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Path("api/usuario/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class UsuarioController {
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@GET 
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{email}")
	public Response TemEmail(@PathParam("email") String email){
		boolean existe = usuarioDAO.ExisteEmail(email);
		return Response.ok(existe).build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("logar/")
	public Response Logar(UsuarioLogarViewModel usuarioLogar) throws Exception{		
		UsuarioViewModel usuario = usuarioDAO.Logar(usuarioLogar);
		
		if(usuario != null){
			String compactJws = Jwts.builder()
					.setSubject(usuario.getEmail())
					.signWith(SignatureAlgorithm.HS512, "manual")
					.compact();
			System.out.println(compactJws);
			return Response.ok(usuario).build();
		}
		return Response.serverError().build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("")
	public void Salvar(UsuarioCadastrarViewModel usuarioCadastrar){
		usuarioDAO.Cadastrar(usuarioCadastrar);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, UsuarioAtualizarViewModel usuarioAtualizar){
		usuarioDAO.Atualizar(usuarioAtualizar);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) {
		usuarioDAO.Excluir(id);
	}
}
