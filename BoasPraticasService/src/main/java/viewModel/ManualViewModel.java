package viewModel;

import java.util.List;


public class ManualViewModel {
	private int ID;
	private int Revisao;
	private List<RespostaViewModel> RespostaList;
	
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
	public List<RespostaViewModel> getRespostaList() {
		return RespostaList;
	}
	public void setRespostaList(List<RespostaViewModel> respostaList) {
		RespostaList = respostaList;
	}
}
