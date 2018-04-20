package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Conexao {
		
	//O atributo con n�o pode sofrer altera��es
		private static Connection con;
		
		public static Connection getConexao() {
			con = null;
			
			try{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String dbURL = "jdbc:ucanaccess:////10.107.134.23/banco/agenda.accdb";
				//String dbURL = "jdbc:ucanaccess://C:/Users/17259228/Documents/BancoAgenda.accdb";
				
				con = DriverManager.getConnection(dbURL);
				
			
			}catch(Exception erro){
				
				JOptionPane.showMessageDialog(null, "Conex�o indispon�vel", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				
				System.out.println(erro.getMessage());
			}
			
			return con;
		}
		
		//fechar conex�o
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
