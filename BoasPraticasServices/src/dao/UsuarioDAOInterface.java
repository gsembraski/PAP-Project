package dao;

import domain.Usuario;
import model.UsuarioModel.UsuarioAtualizarViewModel;
import model.UsuarioModel.UsuarioCadastrarViewModel;
import model.UsuarioModel.UsuarioLogarViewModel;

public interface UsuarioDAOInterface {

	Usuario Logar(UsuarioLogarViewModel usuarioLogar);

	void Cadastrar(UsuarioCadastrarViewModel usuarioCadastrar);

	void Atualizar(UsuarioAtualizarViewModel usuarioAtualizar);

	void Excluir(int id);

}