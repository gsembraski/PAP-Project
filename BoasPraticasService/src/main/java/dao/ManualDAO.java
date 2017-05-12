package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;

import entity.Empresa;
import entity.Manual;
import entity.Resposta;
import entity.Usuario;
import viewModel.manualViewModel.ManualAtualizarViewModel;
import viewModel.manualViewModel.ManualCadastroViewModel;
import viewModel.manualViewModel.ManualViewModel;
import viewModel.respostaViewModel.RespostaAtualizarViewModel;
import viewModel.respostaViewModel.RespostaCadastrarViewModel;
import viewModel.respostaViewModel.RespostaViewModel;

@Stateless
public class ManualDAO {
	
	@PersistenceContext(unitName = "BoasPraticasService")
	private EntityManager em;
	
	public void Cadastrar(ManualCadastroViewModel item) {
		Manual manual;
		try{			
			Empresa empresa = em.find(Empresa.class, item.empresaID);
			Usuario usuario = em.find(Usuario.class, empresa.getUsuario().getId());
			List<Resposta> respList = new ArrayList<Resposta>();
			
			manual = new Manual(item.revisao, empresa, usuario);

			int totalResposta = item.respostaList.size();
			
			if(totalResposta > 0)
				for (RespostaCadastrarViewModel resp : item.respostaList) {
					Resposta resposta = new Resposta();
					resposta.setNumeroResposta(resp.numeroResposta);
					resposta.setTexto(resp.texto);
					resposta.setMbp(manual);
					respList.add(resposta);
				}
			manual.setResposta(respList);
			
			em.persist(manual);
		}catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public void Atualizar(ManualAtualizarViewModel item) {
		try{
			List<RespostaAtualizarViewModel> respostaList = item.getRespostaList();
			Manual manual = em.find(Manual.class, item.getID());
			List<Resposta> respostaListE = manual.getResposta();		
			
			for (RespostaAtualizarViewModel respostaViewModel : respostaList) {				
				for (Resposta resposta : respostaListE) {
					if(resposta.getID() == respostaViewModel.getID())
						resposta.Atualizar(respostaViewModel.getNumResp(), respostaViewModel.getTexto());
				}
			}
			
			manual.setRevisao(item.getRevisao());
			manual.setResposta(respostaListE);			
			em.merge(manual);
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ManualViewModel> Buscar(String usuarioEmail) {
		try {
			Usuario usuario = (Usuario) em.createQuery("from Usuario where Email = :email")
					 .setParameter("email", usuarioEmail).getSingleResult();
			
			Query query = em.createQuery("from Manual where Usuario_ID = :usuario_id")
					.setParameter("usuario_id", usuario.getId());
			
			List<Manual> itens = (List<Manual>) query.getResultList();
			List<ManualViewModel> models = new ArrayList<ManualViewModel>();
			
			for (Manual item : itens) {
				ManualViewModel model = new ManualViewModel();
				List<RespostaViewModel> respostaList = new ArrayList<RespostaViewModel>();
				
				model.setID(item.getID());
				model.setRevisao(item.getRevisao());
				
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
	
	public ManualViewModel BuscarItem(int id) {
		try {
			ManualViewModel model = new ManualViewModel();
			List<RespostaViewModel> respostaList = new ArrayList<RespostaViewModel>();
			Manual item = em.find(Manual.class, id);			
			
			model.setID(item.getID());
			model.setRevisao(item.getRevisao());			
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
	
	public void Excluir(int id) {
		try{
			Manual item = em.find(Manual.class, id);
			em.remove(item);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
