package domain;

import domain.Empresa;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ManualBP
 *
 */
@Entity
@Table(name = "manual")
public class ManualBP implements Serializable {

	@Id
	@GeneratedValue
	private Integer ID;
	private String revisao;
	@OneToOne
	private Empresa empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mbp")
	private List<Resposta> resposta;
	
	public List<Resposta> getResposta() {
		return resposta;
	}

	public void setResposta(List<Resposta> resposta) {
		this.resposta = resposta;
	}

	private static final long serialVersionUID = 1L;

	public ManualBP() {
		super();
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getRevisao() {
		return this.revisao;
	}

	public void setRevisao(String revisao) {
		this.revisao = revisao;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


}
