package services;

import domain.Usuario;
import model.UsuarioModel.UsuarioAtualizarViewModel;
import model.UsuarioModel.UsuarioCadastrarViewModel;
import model.UsuarioModel.UsuarioLogarViewModel;

public interface UsuarioInterface {

	Usuario BuscarUsuario(UsuarioLogarViewModel usuarioLogar);

	void Salvar(UsuarioCadastrarViewModel usuarioCadastrar);

	void Atualizar(UsuarioAtualizarViewModel usuarioAtualizar);

	void Delete(int id);

}