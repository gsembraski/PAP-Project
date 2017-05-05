package controller;

import java.util.List;

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

import dao.ManualDAO;
import entity.Manual;
import viewModel.manualViewModel.ManualAtualizarViewModel;
import viewModel.manualViewModel.ManualCadastroViewModel;
import viewModel.manualViewModel.ManualViewModel;

@Path("api/manual/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class ManualController {
	
	@EJB
	private ManualDAO manualDAO;
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{usuarioEmail}")
	public Response Buscar(@PathParam("usuarioEmail") String usuarioEmail){
		List<ManualViewModel> models = manualDAO.Buscar(usuarioEmail);
		return Response.ok(models).build();
	}	
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("buscarItem/{id}")
	public Response TemEmail(@PathParam("id") int id){
		ManualViewModel model = manualDAO.BuscarItem(id);
		return Response.ok(model).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("")
	public void Salvar(ManualCadastroViewModel item){
		manualDAO.Cadastrar(item);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, ManualAtualizarViewModel item){
		manualDAO.Atualizar(item);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) {
		manualDAO.Excluir(id);
	}
}
