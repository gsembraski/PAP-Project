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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dao.*;
import viewModel.*;

@Path("/authenticad/api/empresa/")
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
	@Path("{email}")
	public Response Buscar(@PathParam("email") String email) throws Exception{
		List<EmpresaViewModel> models = empresaDAO.Buscar(email);
		return Response.ok(models).build();
	}	
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,
		       MediaType.TEXT_PLAIN})
	@Path("buscarItem/{id}")
	public Response TemEmail(@PathParam("id") int id) throws Exception{
		EmpresaViewModel model = empresaDAO.BuscarItem(id);
		return Response.ok(model).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("")
	public ResponseEntity<String> Salvar(EmpresaCadastrarViewModel empresa) throws Exception{
		try {
			empresaDAO.Cadastrar(empresa);			
			return new ResponseEntity<String>("Empresa cadastrada com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("CNPJ inválido.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public ResponseEntity<String> Atualizar(@PathParam("id") int id, EmpresaEditarViewModel empresa) throws Exception{
		try {
			empresaDAO.Atualizar(empresa);			
			return new ResponseEntity<String>("Empresa atualizada com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("CNPJ inválido.", HttpStatus.NOT_FOUND);
		}
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.TEXT_PLAIN})
	@Path("{id}")
	public void Excluir(@PathParam("id") int id) throws Exception{
		empresaDAO.Excluir(id);
	}
}
