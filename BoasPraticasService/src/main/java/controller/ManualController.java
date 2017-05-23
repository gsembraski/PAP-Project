package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;

import dao.*;
import viewModel.*;

@Path("/authenticad/api/manual/")
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
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("gerarManual/{id}")
	public Response GerarManual(@PathParam("id") int id) {
		
		
		try {
			File arquivo = manualDAO.GerarManual(id);
			FileInputStream in = new FileInputStream(arquivo);
			
			ResponseBuilder response = Response.ok(in);
		    response.header("Content-Disposition", "attachment; filename=\""+arquivo.getName() +"\"");
		    return response.build();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
