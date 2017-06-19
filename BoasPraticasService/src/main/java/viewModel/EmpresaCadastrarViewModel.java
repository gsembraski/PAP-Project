package viewModel;

import java.awt.Image;

public class EmpresaCadastrarViewModel {
	private String UsuarioEmail;
	private String RazaoSocial;
	private String NomeFantasia;
	private String CNPJ;
	private Image Imagem;
	
	public String getUsuarioEmail() {
		return UsuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		UsuarioEmail = usuarioEmail;
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
	public Image getImagem() {
		return Imagem;
	}
	public void setImagem(Image imagem) {
		Imagem = imagem;
	}
	
}
