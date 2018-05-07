package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.controller.ControllerClienteDAO;
import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FrmCliente extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtID;
	private JTextField txtIdade;
	private JComboBox<String> cbNivel;
	private JComboBox cbSexo;

	private JFormattedTextField txtData;

	private JLabel lblOperacao;

	ClienteDAO dao = new ClienteDAO();

	// métodos para setar os valores dos txtfields
	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));

	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtData(String data) {
		this.txtData.setText(data);
	}

	public void setTxtPeso(int peso) {
		this.txtPeso.setText(String.valueOf(peso));

	}

	public void setTxtAltura(int altura) {
		this.txtAltura.setText(String.valueOf(altura));
	}

	public void setCbSexo(String sexo) {

		dao.setSexo(sexo, cbSexo);

	}

	public void setCbNivel(String nivel) {

		dao.setNivelAtividade(nivel, cbNivel);
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente(String operacao, String title) {
		setTitle(title);
		setBounds(100, 100, 468, 625);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setLayout(null);
		panelDados.setBackground(new Color(155, 194, 255));
		panelDados.setBounds(0, 70, 452, 278);
		panelPrincipal.add(panelDados);

		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeso.setBounds(10, 113, 45, 20);
		panelDados.add(lblPeso);

		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(261, 113, 45, 20);
		panelDados.add(lblAltura);

		JLabel lblDtNasc = new JLabel("Data De Nascimento:");
		lblDtNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDtNasc.setBounds(10, 81, 129, 20);
		panelDados.add(lblDtNasc);

		JLabel lblQuilos = new JLabel("quilos(kg)");
		lblQuilos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuilos.setBounds(152, 113, 60, 20);
		panelDados.add(lblQuilos);

		JLabel lblCent = new JLabel("cm");
		lblCent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCent.setBounds(407, 113, 45, 20);
		panelDados.add(lblCent);

		JLabel lblNivelAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblNivelAtividade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNivelAtividade.setBounds(10, 183, 105, 27);
		panelDados.add(lblNivelAtividade);

		txtNome = new JTextField();
		txtNome.setBounds(60, 50, 382, 20);
		panelDados.add(txtNome);

		txtPeso = new JTextField();
		txtPeso.setBounds(55, 113, 86, 20);
		panelDados.add(txtPeso);

		txtAltura = new JTextField();
		txtAltura.setBounds(311, 113, 86, 20);
		panelDados.add(txtAltura);

		// Criando uma comboBox
		cbNivel = new JComboBox<String>();
		cbNivel.setBounds(125, 186, 152, 24);
		panelDados.add(cbNivel);

		// Vetor para níveis de atividade
		String[] nivelAtividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		// Modelo para ser inserido no ComboBox
		DefaultComboBoxModel<String> modelAtividade = new DefaultComboBoxModel<>(nivelAtividade);

		// Setando o modelo ao combo criado anteriormente
		cbNivel.setModel(modelAtividade);

		// criando mascara de formatação
		MaskFormatter dataMask = null;

		// Instanciando o objeto
		try {
			dataMask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtData = new JFormattedTextField(dataMask);
		txtData.setBounds(138, 82, 120, 20);
		panelDados.add(txtData);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 49, 45, 20);
		panelDados.add(lblNome);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 13, 46, 14);
		panelDados.add(lblID);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(40, 11, 68, 20);
		panelDados.add(txtID);

		JButton btnCalcular = new JButton("");
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/calculator.png")));
		btnCalcular.setBounds(193, 232, 78, 35);
		panelDados.add(btnCalcular);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexo.setBounds(10, 152, 45, 20);
		panelDados.add(lblSexo);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { "Feminino", "Masculino" }));
		cbSexo.setBounds(55, 152, 105, 20);
		panelDados.add(cbSexo);

		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(0, 349, 452, 153);
		panelPrincipal.add(panelResultados);
		panelResultados.setLayout(null);
		panelResultados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultados",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelResultados.setBackground(new Color(155, 194, 255));

		JLabel lblIMC = new JLabel("IMC: ");
		lblIMC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIMC.setBounds(10, 38, 34, 20);
		panelResultados.add(lblIMC);

		JLabel lblResultIMC = new JLabel("...");
		lblResultIMC.setForeground(new Color(14, 66, 147));
		lblResultIMC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultIMC.setBounds(45, 38, 90, 20);
		panelResultados.add(lblResultIMC);

		JLabel lblTMB = new JLabel("TMB: ");
		lblTMB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTMB.setBounds(10, 120, 34, 20);
		panelResultados.add(lblTMB);

		JLabel lblResultTMB = new JLabel("...");
		lblResultTMB.setForeground(new Color(14, 66, 147));
		lblResultTMB.setBounds(45, 121, 90, 20);
		panelResultados.add(lblResultTMB);

		JLabel lblFCM = new JLabel("FCM: ");
		lblFCM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFCM.setBounds(204, 119, 34, 20);
		panelResultados.add(lblFCM);

		JLabel lblResultFCM = new JLabel("...");
		lblResultFCM.setForeground(new Color(14, 66, 147));
		lblResultFCM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultFCM.setBounds(239, 120, 90, 20);
		panelResultados.add(lblResultFCM);

		JLabel lblNivelAtividadeR = new JLabel("N\u00EDvel de Atividade:  ");
		lblNivelAtividadeR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNivelAtividadeR.setBackground(new Color(34, 170, 95));
		lblNivelAtividadeR.setBounds(10, 11, 117, 27);
		panelResultados.add(lblNivelAtividadeR);

		JLabel lblResultadoNivel = new JLabel("...  ");
		lblResultadoNivel.setForeground(new Color(14, 66, 147));
		lblResultadoNivel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoNivel.setBounds(124, 11, 228, 27);
		panelResultados.add(lblResultadoNivel);

		JScrollPane scrollIMC = new JScrollPane();
		scrollIMC.setBounds(6, 56, 440, 53);
		panelResultados.add(scrollIMC);

		JPanel panelIMC = new JPanel();
		scrollIMC.setViewportView(panelIMC);
		panelIMC.setLayout(null);

		JLabel lblClassificacao = new JLabel("...");
		lblClassificacao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblClassificacao.setForeground(Color.BLUE);
		lblClassificacao.setBounds(5, 5, 140, 14);
		panelIMC.add(lblClassificacao);

		JLabel lblSintomas = new JLabel("...");
		lblSintomas.setForeground(Color.BLUE);
		lblSintomas.setBounds(5, 24, 400, 14);
		panelIMC.add(lblSintomas);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(306, 15, 86, 20);
		panelResultados.add(txtIdade);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 452, 71);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(new Color(14, 66, 147));

		JLabel lblTitulo = new JLabel("Clientes");
		lblTitulo.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/logoGym.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setBounds(10, 3, 187, 67);
		panelTitulo.add(lblTitulo);

		lblOperacao = new JLabel(operacao);
		lblOperacao.setForeground(Color.RED);
		lblOperacao.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblOperacao.setBounds(322, 22, 120, 34);
		panelTitulo.add(lblOperacao);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelBotoes.setBounds(0, 500, 452, 91);
		panelPrincipal.add(panelBotoes);
		panelBotoes.setLayout(null);
		panelBotoes.setBackground(new Color(155, 194, 255));

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");

				// data para o banco
				SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");

				Date date = null;

				String dataAccess = "";

				try {
					date = toDate.parse(txtData.getText());

					dataAccess = toDataBase.format(date);

					// Criando um cliente
					Cliente cliente = new Cliente();

					cliente.setNome(txtNome.getText());

					cliente.setDtNascimento(dataAccess);

					cliente.setPeso(Integer.parseInt(txtPeso.getText()));

					cliente.setAltura(Integer.parseInt(txtAltura.getText()));

					cliente.setSexo(cbSexo.getSelectedItem().toString().substring(0, 1));

					cliente.setNivelAtividade((cbNivel.getSelectedItem().toString()));

					ClienteDAO dao = new ClienteDAO();

					dao.setCliente(cliente);

					dao.setOperacaoBanco(lblOperacao.getText(), txtID.getText());

					dao.limparCampos(lblOperacao.getText(), txtNome, txtData, txtID, txtAltura, txtPeso, cbNivel,
							cbSexo);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnSalvar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(10, 24, 71, 56);
		panelBotoes.add(btnSalvar);

		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/cancel.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBounds(368, 24, 71, 56);
		panelBotoes.add(btnCancelar);

		// Criando objeto da classe ClienteAcademia
		Cliente cliente = new Cliente();

		// Eventos para os cálculos
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				txtIdade.setText(String.valueOf(dao.getIdade(txtData.getText())));

				// Setando valores dos atributos do cliente
				cliente.setNome(txtNome.getText());
				cliente.setAltura(Integer.parseInt(txtAltura.getText()));
				cliente.setPeso(Integer.parseInt(txtPeso.getText()));
				// cliente.setIdade(txtIdade.getText());

				cliente.setNivelAtividade(String.valueOf(cbNivel.getSelectedItem()));

				// Dados retornados
				lblResultadoNivel.setText(String.valueOf(cliente.getNivelAtividade()));

				// Resultado do IMC deverá aparecer aqui

				cliente.setImc(dao.calcularIMC(txtPeso.getText(), txtAltura.getText()));

				lblResultIMC.setText(String.valueOf(cliente.getImc()));

				// retornando sintomas e classificação do cliente
				lblClassificacao.setText(dao.setClassificacao(cliente.getImc(), lblClassificacao.getText()));
				lblSintomas.setText(dao.setSintomas(cliente.getImc(), lblSintomas.getText()));

				cliente.setTmb(dao.calcularTMB(Integer.parseInt(txtPeso.getText()),
						Integer.parseInt(txtAltura.getText()), dao.getIdade(txtData.getText()),
						dao.calcularTaxaNivel(cbNivel.getSelectedItem().toString()), cbSexo.getSelectedIndex()));

				lblResultTMB.setText(String.valueOf(cliente.getTmb()));

				// pegando resultados do fcm
				cliente.setFcm(dao.calcularFCM(dao.getIdade(txtData.getText()), Integer.parseInt(txtPeso.getText()),
						cbSexo.getSelectedIndex()));

				lblResultFCM.setText(String.valueOf(cliente.getFcm()));

				// System.out.println(String.valueOf(dao.calcularTMB
				// (Integer.parseInt(txtPeso.getText()), Integer.parseInt(txtAltura.getText(),
				// dao.getIdade(txtData.getText()),
				// dao.calcularTaxaNivel(
				// cbNivel.getSelectedItem().toString()),
				// cbSexo.getSelectedIndex())));

				// classificação e sintomas do cliente
				// cliente.validarClassificacao(cliente.getImc(),
				// String.valueOf(listIMC.getSelectedIndex()));

				// cliente.validarSintomas(cliente.getImc(),
				// String.valueOf(listIMC.getSelectedIndex()));

				// calculando a taxa de nivel de atividade do cliente

				// calculo do tmb

				lblResultTMB.setText(String.valueOf(cliente.getTmb()));

			}
		});
	}
}
