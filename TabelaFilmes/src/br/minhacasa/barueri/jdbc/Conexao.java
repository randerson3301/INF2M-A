package br.minhacasa.barueri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;
	
	//método para tentar a conexão com o banco de dados
	public static Connection getConexao() {
		
		//Vou tentar pegar a classe e o arquivo do banco
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Documents/filmrd.accdb";
			
			con = DriverManager.getConnection(dbURL);
			
			
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Conexão indisponível", 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return con;
	}
	
	//fechando a conexão
	public static void fecharConexao() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				//Para o user
				JOptionPane.showMessageDialog(null, "O Banco já está fechado !", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				
				//Para o desenvolvedor
				System.out.println(e.getMessage());
			}
		}
	}
}
