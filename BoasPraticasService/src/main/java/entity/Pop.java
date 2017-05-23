package entity;

import java.io.Serializable;
import java.lang.Integer;
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

public class Pop implements Serializable {

	@Id
	@GeneratedValue
	private Integer ID;
	private int Revisao;
	private int NumPop;
	@OneToOne
	@NotNull
	private Empresa Empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Pop")
	private List<Resposta> Resposta;
	@ManyToOne
	@NotNull
	private Usuario Usuario;
	
	
	public List<Resposta> getResposta() {
		return Resposta;
	}
	public void setResposta(List<Resposta> resposta) {
		Resposta = resposta;
	}

	private static final long serialVersionUID = 1L;

	public Pop() {
		super();
	}   
	public Pop(int revisao, int numPop, Empresa empresa, Usuario usuario) {
		Revisao = revisao;
		NumPop = numPop;
		Empresa = empresa;
		Usuario = usuario;
	}
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
	  
	public Integer getNumPop() {
		return NumPop;
	}

	public void setNumPop(Integer numPop) {
		NumPop = numPop;
	}   
	  
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
   
}
