package entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import org.hibernate.validator.constraints.br.CNPJ;

import com.sun.istack.internal.NotNull;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue
	private Integer ID;
	@NotNull
	@CNPJ(message = "CNPJ inválido. Por favor, verifique.")
	private String CNPJ;
	@NotNull
	private String RazaoSocial;
	@NotNull
	private String NomeFantasia;
	private byte[] Logo;
	@ManyToOne
	@NotNull
	private Usuario Usuario;
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cnpj) {
		CNPJ = cnpj;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

}
