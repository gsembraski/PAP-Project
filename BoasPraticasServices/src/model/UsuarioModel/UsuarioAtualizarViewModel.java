package model.UsuarioModel;

public class UsuarioAtualizarViewModel {
	
	private Integer Id;
	private String Nome;
	private String Sobrenome;
	private String Email;
	private String Senha;
	
	public UsuarioAtualizarViewModel(Integer id, String nome, String sobrenome, String email, String senha) {
		super();
		Id = id;
		Nome = nome;
		Sobrenome = sobrenome;
		Email = email;
		Senha = senha;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
}
