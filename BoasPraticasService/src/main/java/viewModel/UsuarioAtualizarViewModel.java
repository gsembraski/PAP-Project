package viewModel;

import java.util.Date;

public class UsuarioAtualizarViewModel {
	private Integer ID;
	private String Nome;
	private String Sobrenome;
	private String Email;
	private String Senha;
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSobrenome() {
		return Sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
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
