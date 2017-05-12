package entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import entity.Empresa;
import entity.Resposta;

/**
 * Entity implementation class for Entity: POP
 *
 */
@Entity

public class POP implements Serializable {

	@Id
	private Integer ID;
	private String Revisao;
	@OneToOne
	@NotNull
	private Empresa Empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Pop")
	private List<Resposta> Resposta;
	private Integer NumPop;
	
	
	public List<Resposta> getResposta() {
		return Resposta;
	}
	public void setResposta(List<Resposta> resposta) {
		Resposta = resposta;
	}

	private static final long serialVersionUID = 1L;

	public POP() {
		super();
	}   
	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}   
	public String getRevisao() {
		return Revisao;
	}

	public void setRevisao(String revisao) {
		Revisao = revisao;
	}   
	public Empresa getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Empresa empresa) {
		Empresa = empresa;
	}   
	  
	public Integer getNumPop() {
		return NumPop;
	}

	public void setNumPop(Integer numPop) {
		NumPop = numPop;
	}
   
}
