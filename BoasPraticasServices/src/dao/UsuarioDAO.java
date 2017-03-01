package dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.WebApplicationException;

import domain.Usuario;
import proj.Produto;

public class UsuarioDAO {

	@Resource
	private UserTransaction ut;
	
	@PersistenceContext
	private EntityManager em;
	
	public static Usuario getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Logar(model.UsuarioModel.UsuarioLogarViewModel)
	 */
	public Usuario Logar(Usuario usuarioLogar) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Cadastrar(model.UsuarioModel.UsuarioCadastrarViewModel)
	 */
	@Transactional
	public void Cadastrar(Usuario usuarioCadastrar) {
		
		try {
			em = Persistence.createEntityManagerFactory("BoasPraticasServices").createEntityManager();			
			ut.begin();
			em.persist(usuarioCadastrar);
			ut.commit();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}


	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Atualizar(model.UsuarioModel.UsuarioAtualizarViewModel)
	 */
	public void Atualizar(Usuario usuarioAtualizar) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Excluir(int)
	 */
	public void Excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
