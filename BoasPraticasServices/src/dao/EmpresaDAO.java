package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;

import entity.Empresa;
import entity.Usuario;
import viewModel.empresaViewModel.EmpresaCadastrarViewModel;
import viewModel.empresaViewModel.EmpresaEditarViewModel;
import viewModel.empresaViewModel.EmpresaViewModel;

@Stateless
public class EmpresaDAO {
		
	@PersistenceContext(unitName = "BoasPraticasServices")
	private EntityManager em;
	
	public void Cadastrar(EmpresaCadastrarViewModel item) throws Exception {
		try {

			Usuario usuario = em.find(Usuario.class, item.UsuarioID);
			Empresa empresa = new Empresa();
			empresa.setCNPJ(item.CNPJ);
			empresa.setRazaoSocial(item.RazaoSocial);
			empresa.setNomeFantasia(item.NomeFantasia);
			empresa.setUsuario(usuario);
			
			em.persist(empresa);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void Atualizar(EmpresaEditarViewModel item) throws Exception {
		try{
			
			Empresa empresa = em.find(Empresa.class, item.getID());		

			empresa.setCNPJ(item.getCNPJ());
			empresa.setNomeFantasia(item.getNomeFantasia());
			empresa.setRazaoSocial(item.getRazaoSocial());
			em.merge(empresa);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpresaViewModel> Buscar(int usuarioID) throws Exception {
		try {
			Query query = em.createQuery("from Empresa where usuario_id = :usuario_id");
			query.setParameter("usuario_id", usuarioID);
			
			List<Empresa> itens = (List<Empresa>) query.getResultList();
			List<EmpresaViewModel> models = ToListViewModel(itens);
			
			return models;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public EmpresaViewModel BuscarItem(int id) throws Exception {
		try {
			Empresa item = em.find(Empresa.class, id);
			
			EmpresaViewModel model = ToViewModel(item);
			return model;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void Excluir(int id) {
	    Empresa item = em.find(Empresa.class, id);
		em.remove(item);
	}
	
	public static EmpresaViewModel ToViewModel(Empresa item){
		EmpresaViewModel model = new EmpresaViewModel();
		model.setID(item.getID());
		model.setCNPJ(item.getCNPJ());
		model.setNomeFantasia(item.getNomeFantasia());
		model.setRazaoSocial(item.getRazaoSocial());
		return model;
	}
	
	public static List<EmpresaViewModel> ToListViewModel(List<Empresa> itens){
		List<EmpresaViewModel> models = new ArrayList<EmpresaViewModel>();
		for (Empresa item : itens) {
			EmpresaViewModel model = new EmpresaViewModel();

			model.setID(item.getID());
			model.setCNPJ(item.getCNPJ());
			model.setNomeFantasia(item.getNomeFantasia());
			model.setRazaoSocial(item.getRazaoSocial());
			models.add(model);
		}
		return models;
	}
}
