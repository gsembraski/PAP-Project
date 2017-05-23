package viewModel;

import java.util.List;


public class PopViewModel {
	private int ID;
	private int Revisao;
	private String EmpresaRazaoSociao;
	private int NumPop;
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
	
	public void setEmpresaRazaoSociao(String empresaRazaoSociao) {
		EmpresaRazaoSociao = empresaRazaoSociao;
	}
	
	public String getEmpresaRazaoSociao() {
		return EmpresaRazaoSociao;
	}
	
	public void setRevisao(int revisao) {
		Revisao = revisao;
	}
	
	public int getNumPop() {
		return NumPop;
	}
	
	public void setNumPop(int numPop) {
		NumPop = numPop;
	}
	
	public List<RespostaViewModel> getRespostaList() {
		return RespostaList;
	}
	
	public void setRespostaList(List<RespostaViewModel> respostaList) {
		RespostaList = respostaList;
	}
}
