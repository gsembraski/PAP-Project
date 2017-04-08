package model;

public class EmpresaCadastrarViewModel {
	public int UsuarioID;
	public String RazaoSocial;
	public String NomeFantasia;
	public String CNPJ;
	
	public int getUsuarioID() {
		return UsuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		UsuarioID = usuarioID;
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
