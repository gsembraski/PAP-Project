package viewModel;

import java.util.List;


public class ManualAtualizarViewModel {
	private int ID;
	private int Revisao;
	private List<RespostaAtualizarViewModel> RespostaList;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getRevisao() {
		return Revisao;
	}
	public void setRevisao(int revisao) {
		Revisao = revisao;
	}
	public List<RespostaAtualizarViewModel> getRespostaList() {
		return RespostaList;
	}
	public void setRespostaList(List<RespostaAtualizarViewModel> respostaList) {
		RespostaList = respostaList;
	}
}
