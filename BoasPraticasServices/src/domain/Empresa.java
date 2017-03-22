package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

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
	private String CNPJ;
	private String razaoSocial;
	private String nomeFantasia;
	private Byte logo;
	@ManyToOne
	private Usuario usuario;
	@OneToOne(mappedBy = "empresa")
	private ManualBP manual;
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Byte getLogo() {
		return logo;
	}

	public void setLogo(Byte logo) {
		this.logo = logo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ManualBP getManual() {
		return manual;
	}

	public void setManual(ManualBP manual) {
		this.manual = manual;
	}

}
