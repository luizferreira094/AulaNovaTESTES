package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static Empresa empresaEsperada;
	static Empresa empresaObtida;
	static EmpresaDAO empresaDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaEsperada = new Empresa();
		empresaEsperada.setNomeDaEmpresa("empresa x");
		empresaEsperada.setCnpj("89424232000180");
		empresaEsperada.setNomeFantasia("empresa x");
		empresaEsperada.setEndereco("rua taquari");
		empresaEsperada.setTelefone("2222");
		empresaObtida = new Empresa();
		empresaDAO = new EmpresaDAO();
		empresaDAO.adiciona(empresaEsperada);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	/**
	 * estabelece as pre-condicoes antes da execucao de cada teste
	 * @throws Exception
	 */
	@After
	public void excluiEmpresa() throws Exception{
		empresaDAO.exclui("89424232000180");
	}
	@Test
	public void CT01ConsultarEmpresa_com_sucesso() {
		empresaObtida = empresaDAO.consulta("89424232000180");
		assertTrue(empresaEsperada.equals(empresaObtida));
	}

}
