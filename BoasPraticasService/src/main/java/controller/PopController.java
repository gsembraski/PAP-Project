package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import viewModel.*;

@Path("/authenticad/api/pop/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class PopController {
	
	@EJB
	private PopDAO popDAO;
	
	@GET
	@Path("{numPop}/{usuarioEmail}")
	public Response Buscar(@PathParam("numPop") int numPop, @PathParam("usuarioEmail") String usuarioEmail){
		List<PopViewModel> models = popDAO.Buscar(usuarioEmail, numPop);
		return Response.ok(models).build();
	}	
	
	@GET
	@Path("buscarItem/{id}")
	public Response TemEmail(@PathParam("id") int id){
		PopViewModel model = popDAO.BuscarItem(id);
		return Response.ok(model).build();
	}
	
	@POST
	@Path("")
	public void Salvar(PopCadastroViewModel item){
		popDAO.Cadastrar(item);
	}
	
	@PUT
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, PopAtualizarViewModel item){
		popDAO.Atualizar(item);
	}
	
	@DELETE
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) {
		popDAO.Excluir(id);
	}
}
