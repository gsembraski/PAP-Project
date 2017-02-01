package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Usuario;

public class conexao {
	
	/*
	 * classe exemplo de como inserir um objeto no banco de dados
	 * 
	 */
	@PersistenceContext
	private static EntityManager em;
	
	@SuppressWarnings("deprecation")
	public static void inserirUsuario() {
			
		Usuario user = new Usuario();
		
		Date data = new Date();
		data.setDate(31);
		
		user.setNome("gabriel");
		user.setEmail("email@aaa.com");
		user.setSenha("passw");
		user.setSobrenome("noga");
		user.setUltimoAcesso(data);
		
		em.persist(user);
	}
	
	public static void main(String[] args) {
		inserirUsuario();
	}
}
