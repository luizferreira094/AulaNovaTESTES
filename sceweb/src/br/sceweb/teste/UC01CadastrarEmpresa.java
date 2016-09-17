package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.servico.dao.EmpresaDAO;

public class UC01CadastrarEmpresa {
	
	static EmpresaDAO empresaDAO;
	static Empresa empresa;

	/**
	 * Estabelece pré-condições de teste
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
	}
	
	/**
	 * Verificar o comportamento do sistema na inclusão de ima empresa com sucesso
	 */
	@Test
	public void test() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	

}
