package viewModel.manualViewModel;

import java.util.List;

import viewModel.respostaViewModel.RespostaViewModel;


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
