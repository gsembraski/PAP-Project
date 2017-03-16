package model;

import java.util.Date;

public class UsuarioViewModel {
	public Integer ID;
	public String Nome;
	public String Sobrenome;
	public String Email;
	public String Guid;
	public Date UltimoAcesso;
	public String Mensagem;
	
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
		return Guid;
	}
	public void setSenha(String guid) {
		Guid = guid;
	}
	public Date getUltimoAcesso() {
		return UltimoAcesso;
	}
	public void setUltimoAcesso(Date ultimoAcesso) {
		UltimoAcesso = ultimoAcesso;
	}
	public String getMensagem() {
		return Mensagem;
	}
	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
}
