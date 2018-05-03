package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	/*
	 * Esta classe � respons�vel por abrir a conex�o entre o sistema 
	 * e o Banco de dados.
	 */
	private static Connection con; //abre a conex�o(t�nel).
	
	private static Connection getConexao() {
		con = null;
		
		try {
			
			//Busca o caminho da classe UcanaccessDriver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			//Caminho onde o banco de dados est�.
			String dbURL = "jdbc:ucanaccess://C:/Users/Mendes/Documents/Academia.accdb";
			
			con = DriverManager.getConnection(dbURL);
			
				
		} catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel "
					+ "abrir a conex�o.", "Error Message", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		return con;
	}
	
	//fechar conex�o com o banco
	private static void fecharConexao() {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				
				JOptionPane.showMessageDialog(null, "A conex�o j� foi "
						+ "finalizada.", "Error Message", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
