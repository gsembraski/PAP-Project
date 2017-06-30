package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
@Table (name="usuario")
public class Usuario implements Serializable {
	public Usuario(){};

	@Id
	@GeneratedValue
	private Integer ID;
	private String Nome;
	private String Sobrenome;
	private String Email;
	private String Senha;
	private Date UltimoAcesso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Usuario")
	private List<Empresa> EmpresaLista;
	private static final long serialVersionUID = 1L;

	public Usuario(String nome,
				   String sobrenome,
				   String email,
				   String senha) {
		Nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
		Sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1);
		Email = email;
		Senha = senha;
	}
	
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
		Nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
	}   
	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1);
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
