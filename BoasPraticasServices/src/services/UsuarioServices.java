package services;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import dao.UsuarioDAOInterface;
import domain.Usuario;
import model.UsuarioModel.UsuarioAtualizarViewModel;
import model.UsuarioModel.UsuarioCadastrarViewModel;
import model.UsuarioModel.UsuarioLogarViewModel;

public class UsuarioServices implements UsuarioInterface {

	@PersistenceContext(unitName="BoasPraticasServices")
	private EntityManager Entity;
	
	@Inject
	public UsuarioDAOInterface UsuarioDAOInterface;
	/* (non-Javadoc)
	 * @see services.UsuarioInterface#BuscarUsuario(model.UsuarioModel.UsuarioLogarViewModel)
	 */
	@Override
	@Transactional
	public Usuario BuscarUsuario(UsuarioLogarViewModel usuarioLogar) {
		// TODO Auto-generated method stub
		return UsuarioDAOInterface.Logar(usuarioLogar);
	}

	/* (non-Javadoc)
	 * @see services.UsuarioInterface#Salvar(model.UsuarioModel.UsuarioCadastrarViewModel)
	 */
	@Override
	@Transactional
	public void Salvar(UsuarioCadastrarViewModel usuarioCadastrar) {
		// TODO Auto-generated method stub
		UsuarioDAOInterface.Cadastrar(usuarioCadastrar);
		
	}

	/* (non-Javadoc)
	 * @see services.UsuarioInterface#Atualizar(model.UsuarioModel.UsuarioAtualizarViewModel)
	 */
	@Override
	@Transactional
	public void Atualizar(UsuarioAtualizarViewModel usuarioAtualizar) {
		// TODO Auto-generated method stub
		UsuarioDAOInterface.Atualizar(usuarioAtualizar);
	}

	/* (non-Javadoc)
	 * @see services.UsuarioInterface#Delete(int)
	 */
	@Override
	@Transactional
	public void Delete(int id) {
		// TODO Auto-generated method stub
		UsuarioDAOInterface.Excluir(id);
	}

}
