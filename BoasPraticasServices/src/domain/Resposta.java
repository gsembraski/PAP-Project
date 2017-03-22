package domain;

import domain.ManualBP;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

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
	private int numeroResposta;
	private String respostaValor;
	@ManyToOne
	private ManualBP mbp;
	@ManyToOne
	private POP pop;
	private static final long serialVersionUID = 1L;

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
		return this.numeroResposta;
	}

	public void setNumeroResposta(int numeroResposta) {
		this.numeroResposta = numeroResposta;
	}   
	public String getRespostaValor() {
		return this.respostaValor;
	}

	public void setRespostaValor(String respostaValor) {
		this.respostaValor = respostaValor;
	}   
	public ManualBP getMbp() {
		return this.mbp;
	}

	public void setMbp(ManualBP mbp) {
		this.mbp = mbp;
	}
   
}
