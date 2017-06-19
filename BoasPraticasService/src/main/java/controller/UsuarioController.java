package controller;

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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dao.*;
import viewModel.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
	public ResponseEntity<UsuarioViewModel> Logar(UsuarioLogarViewModel usuarioLogar) throws Exception{		
		try{
		UsuarioViewModel usuario = usuarioDAO.Logar(usuarioLogar);
		
		if(usuario != null){
			String compactJws = Jwts.builder()
					.setSubject(usuario.getEmail())
					.signWith(SignatureAlgorithm.HS512, "manual")
					.compact();
		}
			return new ResponseEntity<UsuarioViewModel>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UsuarioViewModel>(HttpStatus.NOT_FOUND);
		}
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
	public void Atualizar(@PathParam("id") int id, UsuarioAtualizarViewModel usuarioAtualizar) throws Exception{
		usuarioDAO.Atualizar(usuarioAtualizar);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{email}")
	public Response Excluir(@PathParam("email") String email) {
		try {
			boolean usuarioExcluido = usuarioDAO.Excluir(email);
			if(usuarioExcluido)
				return Response.ok().build();
			return Response.status(404).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("buscarItem/{email}")
	public Response BuscarItem(@PathParam("email") String email) throws Exception{
		UsuarioViewModel model = usuarioDAO.BuscarItem(email);
		return Response.ok(model).build();
	}	
}
