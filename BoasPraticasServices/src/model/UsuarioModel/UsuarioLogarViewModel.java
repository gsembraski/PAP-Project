package model.UsuarioModel;

public class UsuarioLogarViewModel {

	public String Email;
	public String Senha;
	
	public UsuarioLogarViewModel(String email, String senha) {
		super();
		Email = email;
		Senha = senha;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
}