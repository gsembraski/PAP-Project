package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity
public class Empresa implements Serializable {

	@Id
	@GeneratedValue
	private Integer ID;
	@NotNull
	@org.hibernate.validator.constraints.br.CNPJ
	private String CNPJ;
	@NotNull
	private String RazaoSocial;
	@NotNull
	private String NomeFantasia;
	private byte[] Logo;
	@ManyToOne
	@NotNull
	private Usuario Usuario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Empresa")
	private List<Manual> ManualLista;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Empresa")
	private List<Pop> PopLista;
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

	public List<Manual> getManualLista() {
		return ManualLista;
	}

	public void setManualLista(List<Manual> manualLista) {
		ManualLista = manualLista;
	}

	public List<Pop> getPopLista() {
		return PopLista;
	}

	public void setPopLista(List<Pop> popLista) {
		PopLista = popLista;
	}

}
