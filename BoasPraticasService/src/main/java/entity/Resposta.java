package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Resposta
 *
 */
@Entity
@Table(name = "resposta")
public class Resposta implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer ID;
	
	private int NumeroResposta;
	
	@Column(columnDefinition = "TEXT")
	private String Texto;
	
	@ManyToOne
	private Manual Manual;
	
	@ManyToOne
	private Pop Pop;
	
	private static final long serialVersionUID = 1L;

	public Resposta(int numResp,
					String texto,
					Manual manual,
					Pop pop) {
		NumeroResposta = numResp;
		Texto = texto;
		Manual = manual;
		Pop = pop;
	}
	
	public void Atualizar(int numResp,
						  String texto) {
	NumeroResposta = numResp;
	Texto = texto;
	}  

	public Resposta() {
		super();
	}  
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public int getNumeroResposta() {
		return NumeroResposta;
	}

	public void setNumeroResposta(int numeroResposta) {
		NumeroResposta = numeroResposta;
	}   
	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}   
	
	public Manual getMbp() {
		return Manual;
	}

	public void setMbp(Manual manual) {
		Manual = manual;
	}

	public Pop getPop() {
		return Pop;
	}

	public void setPop(Pop pop) {
		Pop = pop;
	}
}
