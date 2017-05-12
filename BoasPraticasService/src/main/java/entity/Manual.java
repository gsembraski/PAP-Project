package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: ManualBP
 *
 */
@Entity
public class Manual implements Serializable {

	@Id
	@GeneratedValue
	private Integer ID;
	
	private int Revisao;
	
	@OneToOne
	@NotNull
	private Empresa Empresa;
	
	@ManyToOne
	@NotNull
	private Usuario Usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Manual")
	private List<Resposta> RespostaList;
	
	public Manual(int revisao,
				  Empresa empresa,
				  Usuario usuario){
		Revisao = revisao;
		Empresa = empresa;
		Usuario = usuario;
	}
	
	public void Atualizar(int revisao,
				  		  List<Resposta> respostaList){
		Revisao = revisao;
		RespostaList = respostaList;
	}
	
	public Manual() {
		super();
	}
	
	public List<Resposta> getResposta() {
		return RespostaList;
	}

	public void setResposta(List<Resposta> respostas) {
		RespostaList = respostas;
	}

	private static final long serialVersionUID = 1L;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public int getRevisao() {
		return Revisao;
	}

	public void setRevisao(int revisao) {
		Revisao = revisao;
	}

	public Empresa getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Empresa empresa) {
		Empresa = empresa;
	}


}
