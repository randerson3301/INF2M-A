package br.senai.sp.jandira.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;

public class ContatoDAO {
	
	private Contato contato;
	private ResultSet result;
	private PreparedStatement stm;
	
	
	//Métodos
	public void setContato(Contato contato) {
		this.contato = contato;
	}



	public ResultSet getContatos() {
		
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		//String dbURL = "jdbc:ucanaccess:////10.107.134.3/banco2/agenda.accdb";
		
		result = null;
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			
			
			result = stm.executeQuery();
			
			Conexao.fecharConexao();
			
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a conexão", 
					"Erro",  JOptionPane.ERROR_MESSAGE);
			
			System.out.println(erro.getMessage());
		}
		
		
		return result;
	}
	
	
	
public ArrayList<Contato> getListaContatos() {
		ArrayList<Contato> contatos = new ArrayList<>();
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		//String dbURL = "jdbc:ucanaccess:////10.107.134.3/banco2/agenda.accdb";
		
		result = null;
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			
			
			result = stm.executeQuery();
			
			while(result.next()) {
				Contato contato = new Contato();
				
				contato.setId(result.getInt("id"));
				contato.setNome(result.getString("nome"));
				contato.setDtNasc(result.getString("dtNasc"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				contato.setCelular(result.getString("celular"));
				contato.setTelefone(result.getString("telefone"));
				contato.setSexo(result.getString("sexo"));
				
				//Adicionando a coleção
				contatos.add(contato);
			}
			
			Conexao.fecharConexao();
			
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a conexão", 
					"Erro",  JOptionPane.ERROR_MESSAGE);
			
			System.out.println(erro.getMessage());
		}
		
		
		return contatos;
	}
public Contato getContato(int id) {
	
	Contato contato = new Contato();
	
	String consulta = "SELECT * FROM contatos WHERE id = ?";
	//String dbURL = "jdbc:ucanaccess:////10.107.134.3/banco2/agenda.accdb";
	
	result = null;
	stm = null;
	
	try{
		stm = Conexao.getConexao().prepareStatement(consulta);
		stm.setInt(1, id);
		
		
		result = stm.executeQuery();
		
			result.next();
			contato.setId(result.getInt("id"));
			contato.setNome(result.getString("nome"));
			contato.setDtNasc(String.valueOf(result.getDate("dtNasc")));
			contato.setEmail(result.getString("email"));
			contato.setEndereco(result.getString("endereco"));
			contato.setCelular(result.getString("celular"));
			contato.setTelefone(result.getString("telefone"));
			contato.setSexo(result.getString("sexo"));
			
			
			//Adicionando a coleção
			
		
		Conexao.fecharConexao();
		
	} catch(Exception erro) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a conexão", 
				"Erro",  JOptionPane.ERROR_MESSAGE);
		
		System.out.println(erro.getMessage());
	}
	
	
		return contato;
	}
	
	public void gravar() {
		
	}
	
	public void atualizar() {
		
	}
	
	public void excluir() {
		
	}
}
