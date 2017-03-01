package dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.WebApplicationException;

import domain.Usuario;

@Stateless
public class UsuarioDAO {
	
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

	public void Cadastrar(Usuario usuarioCadastrar) {
		
		try {
			em.persist(usuarioCadastrar);
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
