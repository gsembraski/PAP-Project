package controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Usuario;
import model.UsuarioModel.UsuarioAtualizarViewModel;
import model.UsuarioModel.UsuarioCadastrarViewModel;
import model.UsuarioModel.UsuarioLogarViewModel;
import services.UsuarioInterface;

@Path("usuario/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class UsuarioController {
	
	@Inject
	private UsuarioInterface UsuarioInterface;
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("logar/")
	public Usuario Logar(UsuarioLogarViewModel usuarioLogar){		
		return UsuarioInterface.BuscarUsuario(usuarioLogar);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	public void Salvar(UsuarioCadastrarViewModel usuarioCadastrar){
		UsuarioInterface.Salvar(usuarioCadastrar);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, UsuarioAtualizarViewModel usuarioAtualizar){
		UsuarioInterface.Atualizar(usuarioAtualizar);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) {
		UsuarioInterface.Delete(id);
	}
}
