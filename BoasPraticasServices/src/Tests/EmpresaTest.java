package Tests;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import dao.EmpresaDAO;
import entity.Empresa;
import viewModel.empresaViewModel.EmpresaCadastrarViewModel;

public class EmpresaTest {
	
	@Inject
	private EmpresaDAO empresaDAO = new EmpresaDAO();
	
	@Test
	public void PossoExecutarOperacoesCRUD() throws Exception{
		Empresa prova = new Empresa();
		
		EmpresaCadastrarViewModel cadastrar = new EmpresaCadastrarViewModel();
		cadastrar.RazaoSocial = "Brasiliana Pizzaria LTDA";
		cadastrar.NomeFantasia = "Pizzaria Brasiliana";
		cadastrar.CNPJ = "183612648980001";
		cadastrar.UsuarioID = 1;
		empresaDAO.Cadastrar(cadastrar);
	}
	
}