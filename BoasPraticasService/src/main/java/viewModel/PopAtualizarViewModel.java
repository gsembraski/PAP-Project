package viewModel;

import java.util.List;


public class PopAtualizarViewModel {
	private int ID;
	private int Revisao;
	private String EmpresaRazaoSociao;
	private int NumPop;
	private List<RespostaAtualizarViewModel> RespostaList;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setEmpresaRazaoSociao(String empresaRazaoSociao) {
		EmpresaRazaoSociao = empresaRazaoSociao;
	}
	
	public String getEmpresaRazaoSociao() {
		return EmpresaRazaoSociao;
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
	
	public int getNumPop() {
		return NumPop;
	}
	
	public void setNumPop(int numPop) {
		NumPop = numPop;
	}
}
