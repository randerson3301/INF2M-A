package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ClienteDAO {
	private PreparedStatement stm;
	
	private ResultSet result;
	
	private Cliente cliente;
	
	//método de consulta no Banco de Dados
	
	public ResultSet getClientes() {
		String sql = "SELECT * FROM clientes ORDER BY nome ASC";
		result = null;
		stm = null;
		
		
		try {
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			result = stm.executeQuery();
			
			System.out.println("Ok");
			
			Conexao.fecharConexao();
			
			
		} catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Não foi "
					+ "possível fazer a consulta. Por Favor,"
					+ "tente novamente mais tarde. ", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return result;
	}
	
	//método do arraylist
	public ArrayList<Cliente> getListaClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes ORDER BY nome ASC";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			
			result = stm.executeQuery();
			
			
			//Enquanto o cursor se movimentar para baixo.
			while(result.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(result.getInt("id"));
				cliente.setAltura(result.getInt("altura"));
				cliente.setDtNascimento(result.getString("dtNasc"));
				cliente.setPeso(result.getInt("peso"));
				cliente.setNome(result.getString("nome"));
				cliente.setNivelAtividade(
						result.getString("niveAtividade"));

				clientes.add(cliente);
			}
			
			System.out.println("Ok!!");
			
			Conexao.fecharConexao();
			
			
			
		} catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Não foi "
					+ "possível fazer a consulta. Por Favor,"
					+ "tente novamente mais tarde. ", "Error", 
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		return clientes;
	}
	
	//método para pegar os dados do cliente quando ele for selecionado
	public Cliente getCliente(int id) {
		
		String sql = "SELECT FROM clientes WHERE id = ?";
		
		try {
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setInt(1, id);
			
			result = stm.executeQuery();
			
			//Recebe os dados do cliente diretamente
			result.next();
			
			cliente.setId(result.getInt("id"));
			cliente.setAltura(result.getInt("altura"));
			cliente.setDtNascimento(result.getString("dtNasc"));
			cliente.setPeso(result.getInt("peso"));
			cliente.setNome(result.getString("nome"));
			cliente.setNivelAtividade(
					result.getString("niveAtividade"));
			
			System.out.println("Ok!!!!!!!!");
			
			Conexao.fecharConexao();
			
			
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Não foi "
					+ "possível fazer a consulta. Por Favor,"
					+ "tente novamente mais tarde. ", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		return cliente;
	}
	
	
	//método para adicionar um novo cliente ao banco de dados
	public void gravar() {
		
		//comando sql
		String sql = "INSERT INTO clientes(nome, dtNasc, peso, altura,"
				+ "sexo, nivelAtividade)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try{
			
			Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNascimento());
			stm.setInt(3, cliente.getPeso());
			stm.setInt(4, cliente.getAltura());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getDtNascimento());
			
			stm.execute();
			
			System.out.println("Beleza");
			
			Conexao.fecharConexao();
			

			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Não foi "
					+ "possível adicionar o registro. Por Favor,"
					+ "tente novamente mais tarde. ", "Error", 
					JOptionPane.ERROR_MESSAGE);
			
			
		}
	}
	
	
	//método para excluir um cliente do banco
	public void excluir() {
		//comando sql
				String sql = "DELETE FROM clientes WHERE id = ?";
				
				try{
					
					Conexao.getConexao().prepareStatement(sql);
					
					stm.setInt(1, cliente.getId());
					
					stm.execute();
					
					System.out.println("Beleza");
					
					Conexao.fecharConexao();
				
				}catch(Exception erro) {
					System.out.println(erro.getMessage());
					
					JOptionPane.showMessageDialog(null, "Não foi "
							+ "possível excluir o registro. Por Favor,"
							+ "tente novamente mais tarde. ", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}
	}
	
	
	//método para atualizar os dados de um cliente do banco de dados.
	public void atualizar() {
		//comando sql
				String sql = "UPDATE clientes SET nome = ?, dtNasc = ?,"
						+ "peso = ?, altura = ?, "
						+ "sexo = ?, nivelAtividade = ?";
				
				try{
					
					Conexao.getConexao().prepareStatement(sql);
					
					stm.setString(1, cliente.getNome());
					stm.setString(2, cliente.getDtNascimento());
					stm.setInt(3, cliente.getPeso());
					stm.setInt(4, cliente.getAltura());
					stm.setString(5, cliente.getSexo());
					stm.setString(6, cliente.getDtNascimento());
					
					stm.execute();
					
					System.out.println("Beleza");
					
					System.exit(0);
					
					Conexao.fecharConexao();
					

					
				}catch(SQLException erro) {
					erro.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Não foi "
							+ "possível atualizar o registro. Por Favor,"
							+ "tente novamente mais tarde. ", "Error", 
							JOptionPane.ERROR_MESSAGE);
					
					
				}
	}
	
}
