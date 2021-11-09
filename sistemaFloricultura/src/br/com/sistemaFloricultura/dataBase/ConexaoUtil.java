package br.com.sistemaFloricultura.dataBase;

import java.sql.*;

public class ConexaoUtil {
	// m�todo respons�vel por estabelecer aconex�o com o banco
	public static Connection conector() {

		Connection conexao = null;

		// "Chama" o driver
		String driver = "org.mariadb.jdbc.Driver";

		// Armazenando informa��es referente ao banco
		String url = "jdbc:mariadb://localhost:3306/gerenciadorFloricultura";
		String user = "root";
		String password = "";

		// Estabelecendo a conex�o com o banco de dados
		try {

			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;

		} catch (Exception e) {

			// Serve de apoio para esclarecer o erro
			// System.out.println(e);

			return null;
		}

	}

}
