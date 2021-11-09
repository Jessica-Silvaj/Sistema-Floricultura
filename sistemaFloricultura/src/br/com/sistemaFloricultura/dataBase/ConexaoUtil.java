package br.com.sistemaFloricultura.dataBase;

import java.sql.*;

public class ConexaoUtil {
	// método responsável por estabelecer aconexão com o banco
	public static Connection conector() {

		Connection conexao = null;

		// "Chama" o driver
		String driver = "org.mariadb.jdbc.Driver";

		// Armazenando informações referente ao banco
		String url = "jdbc:mariadb://localhost:3306/gerenciadorFloricultura";
		String user = "root";
		String password = "";

		// Estabelecendo a conexão com o banco de dados
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
