package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
@Table (name="usuario")
public class Usuario implements Serializable {

	public Usuario() {
	}

	@Id
	@GeneratedValue
	private Integer ID;
	private String Nome;
	private String Sobrenome;
	private String Email;
	private String Senha;
	private Date UltimoAcesso;
	private static final long serialVersionUID = 1L;
	

	public Integer getId() {
		return ID;
	}

	public void setId(Integer id) {
		ID = id;
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
	public Date getUltimoAcesso() {
		return UltimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		UltimoAcesso = ultimoAcesso;
	}
}
