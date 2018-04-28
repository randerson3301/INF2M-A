package br.senai.sp.jandira.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;

public class ContatoDAO {
	
	private Contato contato;
	private ResultSet result;
	private PreparedStatement stm;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	
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
			contato.setDtNasc(df.format(result.getDate("dtNasc")));
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
		
		
		String sql = "INSERT INTO contatos" + "( nome, dtNasc, email, endereco,"
				+ " telefone, celular, sexo)" + 
				"VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());

			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			//System.exit(0);
			
			Conexao.fecharConexao();
			
			
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	public void atualizar() {
		String sql = "UPDATE contatos " + "SET nome = ?, dtNasc = ?, email = ?, endereco = ?,"
				+ " telefone = ?, celular = ?, sexo = ? " + 
				"WHERE id = ?";
		
		try{
			
			
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.setInt(8, contato.getId());

			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			System.exit(0);
			
			Conexao.fecharConexao();
			
			
			
		}catch(SQLException erro) {
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}
	
	public void excluir() {
		String sql = "DELETE FROM contatos " + "WHERE id = ?";
		
		try{
			
			
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			
			stm.setInt(1, contato.getId());

			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			System.exit(0);
			
			Conexao.fecharConexao();
			
			
			
		}catch(SQLException erro) {
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}
	
	
}
