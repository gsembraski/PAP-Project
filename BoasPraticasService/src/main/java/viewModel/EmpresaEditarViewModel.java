package viewModel;

public class EmpresaEditarViewModel {
	private int ID;
	private String RazaoSocial;
	private String NomeFantasia;
	private String CNPJ;
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}	
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
}
