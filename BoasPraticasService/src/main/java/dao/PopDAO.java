package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;

import entity.Empresa;
import entity.Manual;
import entity.Pop;
import entity.Resposta;
import entity.Usuario;
import negocio.DocumentoNegocio;
import viewModel.PopAtualizarViewModel;
import viewModel.PopCadastroViewModel;
import viewModel.PopViewModel;
import viewModel.RespostaAtualizarViewModel;
import viewModel.RespostaCadastrarViewModel;
import viewModel.RespostaViewModel;

@Stateless
public class PopDAO {
	
	@PersistenceContext(unitName = "BoasPraticasService")
	private EntityManager em;
	
	public void Cadastrar(PopCadastroViewModel item) {
		Pop pop;
		try{			
			Empresa empresa = em.find(Empresa.class, item.getEmpresaID());
			Usuario usuario = em.find(Usuario.class, empresa.getUsuario().getId());
			List<Resposta> respList = new ArrayList<Resposta>();
			
			pop = new Pop(item.getRevisao(), item.getNumPop(), empresa, usuario);

			int totalResposta = item.getRespostaList().size();
			
			if(totalResposta > 0)
				for (RespostaCadastrarViewModel resp : item.getRespostaList()) {
					Resposta resposta = new Resposta();
					resposta.setNumeroResposta(resp.numeroResposta);
					resposta.setTexto(resp.texto);
					resposta.setPop(pop);
					resposta.setMbp(null);
					respList.add(resposta);
				}
			pop.setResposta(respList);
			
			em.persist(pop);
		}catch (Exception e) {
			throw new WebApplicationException(e.getMessage());
		}
	}
	
	public void Atualizar(PopAtualizarViewModel item) {
		try{
			List<RespostaAtualizarViewModel> respostaList = item.getRespostaList();
			Pop pop = em.find(Pop.class, item.getID());
			List<Resposta> respostaListE = pop.getResposta();		
			
			for (RespostaAtualizarViewModel respostaViewModel : respostaList) {				
				for (Resposta resposta : respostaListE) {
					if(resposta.getID() == respostaViewModel.getID())
						resposta.Atualizar(respostaViewModel.getNumResp(), respostaViewModel.getTexto());
				}
			}
			
			pop.setRevisao(item.getRevisao());
			pop.setResposta(respostaListE);			
			em.merge(pop);
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PopViewModel> Buscar(String usuarioEmail, int popNum) {
		try {
			Usuario usuario = (Usuario) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", usuarioEmail).getSingleResult();
			
			Query query = em.createQuery("from Pop where Usuario_ID = :usuario_id AND NumPop = :num_pop")
					.setParameter("usuario_id", usuario.getId())
					.setParameter("num_pop", popNum);
			
			List<Pop> itens = (List<Pop>) query.getResultList();
			List<PopViewModel> models = new ArrayList<PopViewModel>();
			
			for (Pop item : itens) {
				PopViewModel model = new PopViewModel();
				List<RespostaViewModel> respostaList = new ArrayList<RespostaViewModel>();
				
				model.setID(item.getID());
				model.setRevisao(item.getRevisao());
				model.setEmpresaRazaoSociao(item.getEmpresa().getRazaoSocial());
				
				List<Resposta> respList = item.getResposta();
				for (Resposta resp : respList) {
					RespostaViewModel respItem = new RespostaViewModel();
					respItem.setID(resp.getID());
					respItem.setNumResp(resp.getNumeroResposta());
					respItem.setTexto(resp.getTexto());
					respostaList.add(respItem);
				}
				model.setRespostaList(respostaList);
				models.add(model);
			}
			
			return models;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public PopViewModel BuscarItem(int id) {
		try {
			PopViewModel model = new PopViewModel();
			List<RespostaViewModel> respostaList = new ArrayList<RespostaViewModel>();
			Pop item = em.find(Pop.class, id);			
			
			model.setID(item.getID());
			model.setRevisao(item.getRevisao());	
			model.setNumPop(item.getNumPop());
			
			List<Resposta> respList = item.getResposta();
			for (Resposta resp : respList) {
				RespostaViewModel respItem = new RespostaViewModel();
				respItem.setID(resp.getID());
				respItem.setNumResp(resp.getNumeroResposta());
				respItem.setTexto(resp.getTexto());
				respostaList.add(respItem);
			}
			model.setRespostaList(respostaList);

			return model;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public File GerarPOP(int id) {
		try {
			
			Pop item = em.find(Pop.class, id);

			DocumentoNegocio geradoc = new DocumentoNegocio();
			File arquivo = geradoc.GerarDocumento(null, item);

			return arquivo;
			
		} catch (Exception e) {
			throw new WebApplicationException(e.getMessage(), e);
		}
	}
	
	public void Excluir(int id) {
		try{
			Pop item = em.find(Pop.class, id);
			em.remove(item);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
