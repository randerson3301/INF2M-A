package br.minhacasa.barueri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;
	
	//m�todo para tentar a conex�o com o banco de dados
	public static Connection getConexao() {
		
		//Vou tentar pegar a classe e o arquivo do banco
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Documents/filmrd.accdb";
			
			con = DriverManager.getConnection(dbURL);
			
			
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Conex�o indispon�vel", 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return con;
	}
	
	//fechando a conex�o
	public static void fecharConexao() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				//Para o user
				JOptionPane.showMessageDialog(null, "O Banco j� est� fechado !", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				
				//Para o desenvolvedor
				System.out.println(e.getMessage());
			}
		}
	}
}
