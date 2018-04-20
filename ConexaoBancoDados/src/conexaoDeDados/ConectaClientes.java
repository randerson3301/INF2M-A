package conexaoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Essa classe tem como objetivo reproduzir o conteúdo passado hoje(02/04/2018) no SENAI;
 * Referente a interação entre o Java e o Banco de Dados;
 * Incluindo Comandos SQL.
 */

public class ConectaClientes {

	// execução da classe
	public static void main(String[] args) {
		// gravar();
		ler();
	
		
	}

	// método para gravação de dados
	public static void gravar() {

		Connection con = null;

		PreparedStatement stm = null;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Desktop/BancoDados1.accdb";

			con = DriverManager.getConnection(dbURL);

			String sql = "INSERT INTO cliente" + "(nome, telefone, email, salario, dtNasc)" + "VALUES(?, ?, ?, ?, ?)";

			stm = con.prepareStatement(sql);

			stm.setString(1, "Letícia");
			stm.setString(2, "(11)9874-7584");
			stm.setString(3, "leticia@gmail.com");
			stm.setDouble(4, 1200.10);
			stm.setString(5, "1999-12-06 00:00:00.000000");

			stm.execute();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	//método para retornar os valores solicitados
	public static void ler() {
		Connection con = null;

		PreparedStatement stm = null;

		ResultSet rs = null;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Desktop/BancoDados1.accdb";

			con = DriverManager.getConnection(dbURL);

			String sql = "SELECT id, nome, telefone FROM cliente";

			stm = con.prepareStatement(sql);

			rs = stm.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt("id"));

				System.out.println(rs.getString("nome"));

				System.out.println(rs.getString("telefone"));
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	//método para excluir um registro
	public static void deletar() {

		Connection con = null;

		PreparedStatement stm = null;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Desktop/BancoDados1.accdb";

			con = DriverManager.getConnection(dbURL);

			String sql = "DELETE FROM cliente WHERE id = 6";

			stm = con.prepareStatement(sql);

			
			stm.execute();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
