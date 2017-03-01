package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import domain.Usuario;

public class UsuarioDAO {
	
	@PersistenceContext
	public EntityManager session;
	
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
		
		session.persist(usuarioCadastrar);
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
