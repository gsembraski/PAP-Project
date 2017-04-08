package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;

import domain.Empresa;
import domain.Usuario;
import model.EmpresaCadastrarViewModel;

@Stateless
public class EmpresaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void Cadastrar(EmpresaCadastrarViewModel item) {
		try {

			Usuario usuario = em.find(Usuario.class, item.UsuarioID);
			Empresa empresa = new Empresa();
			empresa.setCNPJ(item.CNPJ);
			empresa.setRazaoSocial(item.RazaoSocial);
			empresa.setNomeFantasia(item.NomeFantasia);
			empresa.setUsuario(usuario);
			
			em.persist(empresa);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public void Atualizar(Empresa item) {
		try{
			
			Empresa empresa = em.find(Empresa.class, item.getID());
			empresa = item;
			em.merge(empresa);
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> Buscar(int usuarioID) {
		try {
			Query query = em.createQuery("from Empresa where usuario_id = :usuario_id");
			query.setParameter("usuario_id", usuarioID);
			
			List<Empresa> models = (List<Empresa>) query.getResultList();
			return models;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public Empresa BuscarItem(int id) {
		try {
			Empresa model = em.find(Empresa.class, id);
			
			return model;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public void Excluir(int id) {
	    Empresa item = em.find(Empresa.class, id);
		em.remove(item);
	}
}
