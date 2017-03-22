package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;

import domain.Empresa;

@Stateless
public class EmpresaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void Cadastrar(Empresa empresaCadastrar) {
		try {
			em.persist(empresaCadastrar);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public void Editar(Empresa empresaEditar) {
		
	}
	
	public List<Empresa> ListaEmpresa(Empresa empresaFind) {
		Query query = em.createQuery("from Empresa where usuario_id = :usuario_id");
		query.setParameter("usuario_id", empresaFind.getUsuario().getId());
		List<Empresa> empresas = (List<Empresa>) query.getResultList();
		return empresas;
	}
	
	public void Excluir(Empresa empresaDel) {
		em.remove(empresaDel);
	}
}
