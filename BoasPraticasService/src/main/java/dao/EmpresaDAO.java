package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.*;
import viewModel.*;

@Stateless
public class EmpresaDAO {
		
	@PersistenceContext(unitName = "BoasPraticasService")
	private EntityManager em;
	
	public void Cadastrar(EmpresaCadastrarViewModel item) throws Exception {
		try {

			Usuario usuario = (Usuario) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", item.getUsuarioEmail()).getSingleResult();
			Empresa empresa = new Empresa();
			empresa.setCNPJ(item.getCNPJ());
			empresa.setRazaoSocial(item.getRazaoSocial());
			empresa.setNomeFantasia(item.getNomeFantasia());
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
	public List<EmpresaViewModel> Buscar(String usuarioEmail) throws Exception {
		try {
			Usuario usuario = (Usuario) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", usuarioEmail).getSingleResult();
			Query query = em.createQuery("from Empresa where usuario_id = :usuario_id");
			query.setParameter("usuario_id", usuario.getId());
			
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
