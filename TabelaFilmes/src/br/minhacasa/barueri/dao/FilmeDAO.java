package br.minhacasa.barueri.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.minhacasa.barueri.jdbc.Conexao;

import br.minhacasa.barueri.model.Filme;

public class FilmeDAO {
	
	//Chamando as classes necessárias.
	
	private Filme filme;
	private  PreparedStatement stm;
	private  ResultSet result;
	
	
	
	//Consultar filmes
	
	public  ResultSet getFilmes() {
		String consulta = "SELECT * FROM filmes "; //comando sql
		
		result = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			
			result = stm.executeQuery();
			
			
			Conexao.fecharConexao();
		
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a conexão", 
					"Erro",  JOptionPane.ERROR_MESSAGE);
		}
		
		return result;
	} 
	
	//método que retorna um arrayList
	
	public ArrayList<Filme> getListaFilmes() {
		ArrayList<Filme> filmes = new ArrayList<>(); // criando um objeto ArrayList
		String consult = "SELECT * FROM filmes ORDER BY titulo ASC";
		
		result = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consult);
			
			result = stm.executeQuery();
			
			while(result.next()) {
				Filme filme = new Filme();
				
				filme.setId(result.getInt("id"));
				filme.setTitulo(result.getString("titulo"));
				filme.setDtLancamento(result.getString("dtLancamento"));
				filme.setDiretor(result.getString("diretor"));
				filme.setDuracao(result.getString("duracao"));
				filme.setGenero(result.getString("genero"));
				filme.setSinopse(result.getString("sinopse"));
				filme.setVisto(result.getString("visto"));
				
				
				filmes.add(filme);
			}
			
			Conexao.fecharConexao();
		
		}catch(SQLException erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Ocorreu um durante a conexão", 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return filmes;
	}
	
	//método para receber dados na aplicação
	public Filme getFilmeDados(int id) {
		Filme filme = new Filme();
		
		String consulta = "SELECT * FROM filmes WHERE id = ?"; //comando sql
		
		result = null;
		stm = null;
		
		try {
			
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id);
			result = stm.executeQuery();
			
			result.next();
			filme.setId(result.getInt("id"));
			filme.setTitulo(result.getString("titulo"));
			filme.setDtLancamento(result.getString("dtLancamento"));
			filme.setDiretor(result.getString("diretor"));
			filme.setDuracao(result.getString("duracao"));
			filme.setGenero(result.getString("genero"));
			filme.setSinopse(result.getString("sinopse"));
			filme.setVisto(result.getString("visto"));
			
			
			Conexao.fecharConexao();
		
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados.", 
					"Erro",  JOptionPane.ERROR_MESSAGE);
		}
		
		return filme;
	}
	
	//método para inserir dados
	public void gravar() {
		
	
		try {
			String add = "INSERT INTO filmes" + 
				"(titulo, dtLancamento, diretor, duracao, genero, sinopse, visto)" 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			stm = Conexao.getConexao().prepareStatement(add);
			
			stm.setString(1, filme.getTitulo());
			stm.setString(2, filme.getDtLancamento());
			stm.setString(3, filme.getDiretor());
			stm.setString(4, filme.getDuracao());
			stm.setString(5, filme.getGenero());
			stm.setString(6, filme.getSinopse());
			stm.setString(7, filme.getVisto());

			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			
			Conexao.fecharConexao();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	//método para eliminação de um registro
	public void deletar() {
		PreparedStatement stm = null;
		
		try {
			String delete = "DELETE FROM filmes WHERE id = 6";
			
			stm = Conexao.getConexao().prepareStatement(delete);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			
			Conexao.fecharConexao();
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	public void atualizar() {
		
		PreparedStatement stm = null;
		
		try {
			String atualizar = "UPDATE filmes SET diretor = 'Alfonso Cuaron' WHERE id = '8'";
			
			stm = Conexao.getConexao().prepareStatement(atualizar);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Sucesso");
			
			Conexao.fecharConexao();
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			
			JOptionPane.showMessageDialog(null, "Não foi possível atualizar", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
