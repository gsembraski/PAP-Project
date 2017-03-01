package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	private Integer Id;
	private String Nome;
	private String sobrenome;
	private String Email;
	private String Senha;
	private Date UltimoAcesso;
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}   
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}   
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public Date getUltimoAcesso() {
		return UltimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		UltimoAcesso = ultimoAcesso;
	}
   
}
