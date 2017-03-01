package controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UsuarioDAO;
import domain.Usuario;

@Path("api/usuario/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class UsuarioController {
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("logar/")
	public Usuario Logar(Usuario usuarioLogar){		
		return usuarioDAO.Logar(usuarioLogar);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("")
	public void Salvar(Usuario usuarioCadastrar){
		usuarioDAO.Cadastrar(usuarioCadastrar);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, Usuario usuarioAtualizar){
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
