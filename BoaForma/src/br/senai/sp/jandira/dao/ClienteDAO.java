package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.view.FrmCliente;

public class ClienteDAO {

	private Cliente cliente;

	private PreparedStatement stm;

	private ResultSet result;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	// m�todo de consulta no Banco de Dados

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ResultSet getClientes() {
		String sql = "SELECT * FROM clientes ORDER BY nome ASC";
		result = null;
		stm = null;

		try {

			stm = Conexao.getConexao().prepareStatement(sql);

			result = stm.executeQuery();

			System.out.println("Ok");

			Conexao.fecharConexao();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "poss�vel fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return result;
	}

	// m�todo do arraylist
	public ArrayList<Cliente> getListaClientes() {
		result = null;
		stm = null;

		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes ORDER BY nome ASC";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);

			result = stm.executeQuery();

			// Enquanto o cursor se movimentar para baixo.
			while (result.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setDtNascimento(result.getString("dtNasc"));
				cliente.setPeso(result.getInt("peso"));
				cliente.setAltura(result.getInt("altura"));
				cliente.setSexo(result.getString("sexo"));
				cliente.setNivelAtividade(result.getString("nivelAtividade"));

				clientes.add(cliente);
			}

			System.out.println("Ok!!");

			Conexao.fecharConexao();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "poss�vel fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);

		}

		return clientes;
	}

	// m�todo para pegar os dados do cliente quando ele for selecionado
	public Cliente getCliente(int id) {
		result = null;
		stm = null;
		String sql = "SELECT * FROM clientes WHERE id = ?";

		Cliente cliente = new Cliente();

		try {

			stm = Conexao.getConexao().prepareStatement(sql);

			stm.setInt(1, id);

			result = stm.executeQuery();

			// Recebe os dados do cliente diretamente
			result.next();

			cliente.setId(result.getInt("id"));
			cliente.setNome(result.getString("nome"));
			cliente.setDtNascimento(df.format(result.getDate("dtNasc")));
			cliente.setPeso(result.getInt("peso"));
			cliente.setAltura(result.getInt("altura"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setNivelAtividade(result.getString("nivelAtividade"));

			System.out.println("Ok!!!!!!!!");

			Conexao.fecharConexao();

		} catch (SQLException erro) {
			// System.out.println(erro.getMessage());
			erro.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "retornar os dados. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return cliente;
	}

	// m�todo para adicionar um novo cliente ao banco de dados
	public void gravar() {
		stm = null;

		// comando sql
		String sql = "INSERT INTO clientes" + "(nome, dtNasc, peso, altura, sexo, nivelAtividade)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);

			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNascimento());
			stm.setInt(3, cliente.getPeso());
			stm.setInt(4, cliente.getAltura());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNivelAtividade());

			stm.execute();

			System.out.println("Foi Adicionado");

			Conexao.fecharConexao();

		} catch (SQLException erro) {
			erro.printStackTrace();
			;

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "poss�vel adicionar o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// m�todo para excluir um cliente do banco
	public void excluir() {
		// comando sql
		String sql = "DELETE FROM clientes WHERE id = ?";

		try {

			stm = Conexao.getConexao().prepareStatement(sql);

			stm.setInt(1, cliente.getId());

			stm.execute();

			System.out.println("Beleza");

			Conexao.fecharConexao();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "poss�vel excluir o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// m�todo para atualizar os dados de um cliente do banco de dados.
	public void atualizar() {
		stm = null;
		// Cliente cliente = new Cliente();

		// comando sql
		String sql = "UPDATE clientes SET nome = ?, dtNasc = ?, " + "peso = ?, altura = ?, "
				+ "sexo = ?, nivelAtividade = ? " + "WHERE id = ?";

		try {

			stm = Conexao.getConexao().prepareStatement(sql);

			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNascimento());
			stm.setInt(3, cliente.getPeso());
			stm.setInt(4, cliente.getAltura());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNivelAtividade());
			stm.setInt(7, cliente.getId());

			stm.execute();

			JOptionPane.showMessageDialog(null, "Beleza");

			Conexao.fecharConexao();

		} catch (SQLException erro) {
			erro.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"N�o foi " + "poss�vel atualizar o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	// realizando as opera��es necess�rias
	public void setOperacaoBanco(String oper, String id) {

		// dao.setCliente(cliente);

		if (oper.equals("Adicionar")) {
			System.out.println(oper);
			gravar();

		} else if (oper.equals("Editar")) {
			cliente.setId(Integer.parseInt(id));
			atualizar();

		} else if (oper.equals("Excluir")) {
			cliente.setId(Integer.parseInt(id));

			int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir " + "o cliente ?", "Confirma��o",
					JOptionPane.OK_OPTION, JOptionPane.CANCEL_OPTION);

			if (confirma == JOptionPane.OK_OPTION) {
				excluir();

			} else {
				JOptionPane.showMessageDialog(null, "O cliente n�o foi excluido", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// setando a sexualidade do cliente
	public void setSexo(String s, JComboBox cb) {
		if (s.equals("F")) {
			cb.setSelectedIndex(0);

		} else if (s.equals("M")) {
			cb.setSelectedIndex(1);

		} else {
			cb.setSelectedIndex(2);
		}
	}

	// setando o nivel de atividade do cliente
	public void setNivelAtividade(String nivel, JComboBox<String> cb) {

		if (nivel.equals("Sedent�rio")) {
			cb.setSelectedIndex(0);

		} else if (nivel.equals("Levemente Ativo")) {
			cb.setSelectedIndex(1);

		} else if (nivel.equals("Moderadamente Ativo")) {
			cb.setSelectedIndex(2);

		} else if (nivel.equals("Bastante Ativo")) {
			cb.setSelectedIndex(3);

		} else if (nivel.equals("Muito Ativo")) {
			cb.setSelectedIndex(4);
		}
	}

	// calculando imc
	public double calcularIMC(String peso, String altura) {
		double p = Double.parseDouble(peso);
		double a = Double.parseDouble(altura);

		a = a / 100;

		return p / (a * a);
	}

	// m�todo para retornar a diferen�a de data
	public int getIdade(String dtNasc) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date dt = new Date();

		String dtPC = df.format(dt);

		int yearNasc = Integer.parseInt(dtNasc.substring(6, 10));

		int yearPC = Integer.parseInt(dtPC.substring(6, 10));

		int monNasc = Integer.parseInt(dtNasc.substring(3, 5));

		int monPC = Integer.parseInt(dtPC.substring(3, 5));

		if (monNasc > monPC) {
			return (yearPC - yearNasc) - 1;
		
		} else if (monNasc < monPC) {
			return (yearPC - yearNasc);
		
		} else {
			int dayNasc = Integer.parseInt(dtNasc.substring(0, 2));

			int dayPC = Integer.parseInt(dtPC.substring(0, 2));
			
			if(dayNasc > dayPC) {
				return (yearPC - yearNasc) - 1;
			
			} else if(dayNasc <= dayPC) {
				return (yearPC - yearNasc);
			}
		}

		return 0;
	}
	
	// m�todo para c�lculo da taxa de nivel de acordo com o cliente
		public double calcularTaxaNivel(String nivelAtividade) {
			if (nivelAtividade.equals("Sedent�rio")) {
				return 1.20;
			}

			else if (nivelAtividade.equals("Levemente Ativo")) {
				return 1.37;
			
			} else if (nivelAtividade.equals("Moderadamente Ativo")) {
				return 1.55;
			
			} else if (nivelAtividade.equals("Bastante Ativo")) {
				return 1.70;

			} else {
				return 1.90;
			} 
		}
		
		// calcular o TMB
		public double calcularTMB(int peso, int altura, int idade, double taxaNivel, int homem) {
			//int p = Integer.parseInt(peso); //convertendo valor do txtPeso para int
			//int a = Integer.parseInt(altura);
			
			System.out.println(idade);

			if (homem == 1) {
				return (66 + (13.7 * peso) + (5 * altura) - (6.8 * idade)) * taxaNivel;

			} else {
				return (665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade)) * taxaNivel;

			}
			
		}
		
		// FCM
		public double calcularFCM(int idade, int peso, int homem) {

			peso = peso / 100;

			if (homem == 1) {
				return ((210 - (0.5 * idade)) - peso) + 4;

			} else  {
				return ((210 - (0.5 * idade))) - peso;

			}
		}
}
