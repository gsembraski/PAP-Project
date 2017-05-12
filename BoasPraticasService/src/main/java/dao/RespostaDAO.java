package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.WebApplicationException;

import entity.Resposta;

@Stateless
public class RespostaDAO {
	
	@PersistenceContext(unitName = "BoasPraticasService")
	private EntityManager em;
	
	public void Cadastrar(Resposta item){
		try{
			Resposta resposta = new Resposta(item.getNumeroResposta(), item.getTexto(), item.getMbp(), item.getPop());
			em.persist(resposta);
			
		}catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public void Atualizar(Resposta item) {
		try{
			
			Resposta resposta = em.find(Resposta.class, item.getID());		
			
			resposta = item;
			em.merge(resposta);
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}
