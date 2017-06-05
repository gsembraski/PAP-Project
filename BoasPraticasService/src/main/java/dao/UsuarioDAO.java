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
					throw new ServletException("Senha inválida.");
				
				
				model = toViewModel(usuario);
				return model;
			}
			else
				throw new ServletException("Usuário não encontrado.");
			
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

	public void Atualizar(UsuarioAtualizarViewModel usuarioAtualizar) {
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

	public void Excluir(int id) {
		// TODO Auto-generated method stub
		
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
