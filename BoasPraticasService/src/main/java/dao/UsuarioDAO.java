package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.ws.rs.WebApplicationException;

import entity.*;
import viewModel.*;;

@Stateless
public class UsuarioDAO {

	@PersistenceContext(unitName = "BoasPraticasService")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDAOInterface#Logar(model.UsuarioModel.UsuarioLogarViewModel)
	 */
	@SuppressWarnings("unchecked")
	public UsuarioViewModel Logar(UsuarioLogarViewModel usuarioLogar) throws Exception {
		UsuarioViewModel model = null;
		try{
			List<Usuario> usuarios = em.createQuery("from Usuario where Email = :email")
				 .setParameter("email", usuarioLogar.getEmail())
				 .getResultList();
			
			if(usuarios.size() > 0){
				Usuario usuario = usuarios.get(0);
				
				if(!usuario.getSenha().equalsIgnoreCase(usuarioLogar.getSenha()))
					throw new ServletException("Senha inv√°lida.");
				
				
				model = toViewModel(usuario);
				return model;
			}
			else
				throw new ServletException("Usu√°rio n√£o encontrado.");
			
		}catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

	public void Cadastrar(UsuarioCadastrarViewModel usuarioCadastrar) {		
		try {
			Usuario usuario = new Usuario(usuarioCadastrar.getNome(), usuarioCadastrar.getSobrenome(), usuarioCadastrar.getEmail(), usuarioCadastrar.getSenha());			
			
			em.persist(usuario);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	public void Atualizar(UsuarioAtualizarViewModel item) throws Exception {
		try{			
			Usuario usuario = em.find(Usuario.class, item.getID());		

			usuario.setNome(item.getNome());
			usuario.setSobrenome(item.getSobrenome());
			usuario.setSenha(item.getSenha());
			
			em.merge(usuario);
			
		} catch (Exception e) {
			throw new Exception(e);
		}		
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

	public boolean Excluir(String email) {
		try{
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", email)
					 .getResultList();
			if(usuarios.size() > 0){
				Usuario item = usuarios.get(0);
				em.remove(item);
				return true;
			}
			return false;
		}catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public UsuarioViewModel BuscarItem(String email) throws Exception {
		try {
			List<Usuario> usuarios = em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", email)
					 .getResultList();
				
			if(usuarios.size() > 0){
				Usuario usuario = usuarios.get(0);
				UsuarioViewModel model = toViewModel(usuario);
				return model;
			}
			else
				throw new ServletException("Usu·rio n„o encontrado.");
				
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static UsuarioViewModel toViewModel(Usuario qr){
		UsuarioViewModel item = new UsuarioViewModel();
		item.setID(qr.getId());
		item.setNome(qr.getNome());
		item.setSobrenome(qr.getSobrenome());
		item.setEmail(qr.getEmail());
		item.setSenha(qr.getSenha());
		
		return item;
	}

}
