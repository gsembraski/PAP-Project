package dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.WebApplicationException;

import domain.Usuario;
import model.UsuarioViewModel;;

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
	public UsuarioViewModel Logar(Usuario usuarioLogar) {
		UsuarioViewModel model = new UsuarioViewModel();
		try{
		Usuario usuario = (Usuario) em.createQuery("from Usuario where Email = :email")
			 .setParameter("email", usuarioLogar.getEmail())
			 .getSingleResult();
		
		if(usuario.getSenha().equalsIgnoreCase(usuarioLogar.getSenha())){
			model = toViewModel(usuario);
			model.setMensagem("Usuario conectado com sucesso!");
			return model;
		}
		else{
			model.setMensagem("Senha inválida.");
			return model;
		}
		}catch (Exception e) {
			return null;
		}
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
	
	public static UsuarioViewModel toViewModel(Usuario qr){
		UsuarioViewModel item = new UsuarioViewModel();
		item.ID = qr.getId();
		item.Nome = qr.getNome();
		item.Sobrenome = qr.getSobrenome();
		item.Email = qr.getEmail();
		item.Guid = qr.getSenha();
		
		return item;
	}

}
