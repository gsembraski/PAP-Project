package viewModel;

import java.util.ArrayList;

public class PopCadastroViewModel {
	private int Revisao;
	private int EmpresaID;
	private int NumPop;
	private ArrayList<RespostaCadastrarViewModel> RespostaList;
	
	public int getRevisao() {
		return Revisao;
	}
	
	public void setRevisao(int revisao) {
		Revisao = revisao;
	}
	
	public int getEmpresaID() {
		return EmpresaID;
	}
	
	public void setEmpresaID(int empresaID) {
		EmpresaID = empresaID;
	}
	
	public int getNumPop() {
		return NumPop;
	}
	
	public void setNumPop(int numPop) {
		NumPop = numPop;
	}
	
	public ArrayList<RespostaCadastrarViewModel> getRespostaList() {
		return RespostaList;
	}
	
	public void setRespostaList(ArrayList<RespostaCadastrarViewModel> respostaList) {
		RespostaList = respostaList;
	}
}
