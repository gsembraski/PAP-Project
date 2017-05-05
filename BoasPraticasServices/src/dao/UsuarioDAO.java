package dao;

import java.util.List;

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

import entity.Usuario;
import viewModel.usuarioViewModel.UsuarioViewModel;;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Logar(model.UsuarioModel.UsuarioLogarViewModel)
	 */
	@SuppressWarnings("unchecked")
	public UsuarioViewModel Logar(Usuario usuarioLogar) {
		UsuarioViewModel model = null;
		try{
			List<Usuario> usuarios = em.createQuery("from Usuario where Email = :email")
				 .setParameter("email", usuarioLogar.getEmail())
				 .getResultList();
			
			if(usuarios.size() > 0){
				Usuario usuario = usuarios.get(0);
				
				if(usuario.getSenha().equalsIgnoreCase(usuarioLogar.getSenha())){
					model = toViewModel(usuario);
					model.setMensagem("Usuario conectado com sucesso!");
				}
			}
			return model;
		}catch (Exception e) {
			throw new WebApplicationException(e);
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
	
	public boolean ExisteEmail(String email){
		try {
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", email)
					 .getResultList();
			if(usuarios.size() > 0){
				return true;
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
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
