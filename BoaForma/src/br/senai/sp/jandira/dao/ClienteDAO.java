package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.view.FrmCliente;

public class ClienteDAO {

	private Cliente cliente;

	private PreparedStatement stm;

	private ResultSet result;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	// método de consulta no Banco de Dados

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
					"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return result;
	}

	// método do arraylist
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
					"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);

		}

		return clientes;
	}

	// método para pegar os dados do cliente quando ele for selecionado
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
					"Não foi " + "retornar os dados. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return cliente;
	}

	// método para adicionar um novo cliente ao banco de dados
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
					"Não foi " + "possível adicionar o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// método para excluir um cliente do banco
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
					"Não foi " + "possível excluir o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// método para atualizar os dados de um cliente do banco de dados.
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
					"Não foi " + "possível atualizar o registro. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	// realizando as operações necessárias
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

			int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir " + "o cliente ?", "Confirmação",
					JOptionPane.OK_OPTION, JOptionPane.CANCEL_OPTION);

			if (confirma == JOptionPane.OK_OPTION) {
				excluir();

			} else {
				JOptionPane.showMessageDialog(null, "O cliente não foi excluido", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// limpando os campos após a adição de um novo contato
	// método para limpar os campos após adicionar um cliente
	public void limparCampos(String s, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5,
			JComboBox<String> box1, JComboBox box2) {

		if (s.equals("Adicionar")) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			box1.setSelectedIndex(0);
			box2.setSelectedIndex(0);

			t1.grabFocus();
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

		if (nivel.equals("Sedentário")) {
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

	// método para validar a classificação de acordo com o imc do cliente
	public String setClassificacao(double imc, String classificacao) {
		if (imc <= 16.9) {
			classificacao = "Muito Abaixo do peso";
			return classificacao;

		} else if (imc <= 18.4) {
			classificacao = " Abaixo do peso";
			return classificacao;

		} else if (imc <= 24.9) {
			classificacao = "Peso Normal";
			return classificacao;

		} else if (imc <= 29.9) {
			classificacao = "Acima do peso";
			return classificacao;

		} else if (imc <= 34.9) {
			classificacao = "Obesidade Grau I";
			return classificacao;

		} else if (imc <= 40) {
			classificacao = "Obesidade Grau II";
			return classificacao;

		} else if (imc > 40) {
			classificacao = "Obesidade Grau III";
			return classificacao;

		} else {
			return "";
		}
	}

	// método para validar os sintomas do usuário
	public String setSintomas(double imc, String sintomas) {
		if (imc <= 16.9) {
			sintomas = "Queda de cabelo, infertilidade, ausência menstrual";
			return sintomas;

		} else if (imc <= 18.4) {
			sintomas = "Fadiga, stress, ansiedade";
			return sintomas;

		} else if (imc <= 24.9) {
			sintomas = "Menor risco de doenças";
			return sintomas;

		} else if (imc <= 29.9) {
			sintomas = "Fadiga, má circulação, varizes";
			return sintomas;

		} else if (imc <= 34.9) {
			sintomas = "Diabetes, angina, infarto, aterosclerose.";
			return sintomas;

		} else if (imc <= 40) {
			sintomas = "Apneia do sono, falta de ar.";
			return sintomas;

		} else if (imc > 40) {
			sintomas = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC ";
			return sintomas;

		} else {
			return "";

		}
	}

	// método para retornar a diferença de data
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

			if (dayNasc > dayPC) {
				return (yearPC - yearNasc) - 1;

			} else if (dayNasc <= dayPC) {
				return (yearPC - yearNasc);
			}
		}

		return 0;
	}

	// método para cálculo da taxa de nivel de acordo com o cliente
	public double calcularTaxaNivel(String nivelAtividade) {
		if (nivelAtividade.equals("Sedentário")) {
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
		// int p = Integer.parseInt(peso); //convertendo valor do txtPeso para int
		// int a = Integer.parseInt(altura);

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

		} else {
			return ((210 - (0.5 * idade))) - peso;

		}
	}
}
