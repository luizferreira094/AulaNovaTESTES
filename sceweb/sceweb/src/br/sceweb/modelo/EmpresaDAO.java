package br.sceweb.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDAO {
	public int adiciona(Empresa empresa) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values(?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	/**
	 * exclui uma empresa pelo cnpj
	 * 
	 * @param cnpj
	 * @return 0 erro na exclusao ou 1 excluido com sucesso
	 */
	public int exclui(String cnpj) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("delete from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			codigoretorno = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return codigoretorno;
	}

	public static Empresa consulta(String cnpj) {
		Empresa empresa = null;
		java.sql.PreparedStatement ps;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("select * from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				empresa = new Empresa();
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setNomeDaEmpresa(resultSet.getString

				("nomeDaEmpresa"));
				empresa.setNomeFantasia(resultSet.getString

				("nomeFantasia"));
				empresa.setEndereco(resultSet.getString("endereco"));
				empresa.setTelefone(resultSet.getString("telefone"));

			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return empresa;
	}
}
