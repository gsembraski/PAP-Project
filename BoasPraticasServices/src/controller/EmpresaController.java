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

import dao.EmpresaDAO;
import domain.Empresa;
import model.EmpresaCadastrarViewModel;

@Path("api/empresa/")
@Produces({MediaType.APPLICATION_JSON,
		  MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
public class EmpresaController {
	
	@EJB
	private EmpresaDAO empresaDAO;
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{usuarioID}")
	public Response Buscar(@PathParam("usuarioID") int usuarioID){
		List<Empresa> models = empresaDAO.Buscar(usuarioID);
		return Response.ok(models).build();
	}	
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("buscarItem/{id}")
	public Response TemEmail(@PathParam("id") int id){
		Empresa model = empresaDAO.BuscarItem(id);
		return Response.ok(model).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("")
	public void Salvar(EmpresaCadastrarViewModel empresa){
		empresaDAO.Cadastrar(empresa);
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Atualizar(@PathParam("id") int id, Empresa empresa){
		empresaDAO.Atualizar(empresa);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) {
		empresaDAO.Excluir(id);
	}
}
