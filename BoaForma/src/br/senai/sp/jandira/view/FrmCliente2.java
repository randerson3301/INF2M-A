package br.senai.sp.jandira.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.model.Cliente;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;

//Herança da classe JFrame
public class FrmCliente2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtIdade;

	// contrutor da classe
	public FrmCliente2() {

		// Colors
		Color white = new Color(255, 255, 255);
		Color yellow = new Color(229, 227, 135);
		Color green = new Color(34, 170, 95);
		Color gray = new Color(214, 214, 214);
		Color blue = new Color(50, 50, 255);

		//Colocando icone para a imagem
		ImageIcon iconCalc = new ImageIcon(FrmCliente2.class.getResource("/br/senai/sp/jandira/Imagens/calc1.png"));
		ImageIcon iconLogo = new ImageIcon(FrmCliente2.class.getResource("/br/senai/sp/jandira/Imagens/logo.png"));
		
		// Tamanho da tela
		setSize(504, 688);

		// Titulo da janela
		setTitle("Calculadora de Calorias");

		// método para encerrar o programa
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		// Criando objetos que irão compor a frame
		JPanel panelDados = new JPanel();
		panelDados.setBounds(0, 100, 488, 266);
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 488, 100);
		

		TitledBorder bordaDados = new TitledBorder("Dados: ");
		TitledBorder bordaResultados = new TitledBorder("Resultados: ");
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblData = new JLabel("Data De Nascimento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblQuilos = new JLabel("quilos(kg)");
		lblQuilos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblCents = new JLabel("cm");
		lblCents.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblHomem = new JLabel("Homem");
		lblHomem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblMulher = new JLabel("Mulher");
		lblMulher.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNivel = new JLabel("N\u00EDvel de Atividade:");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblTitulo = new JLabel("Clientes");

		JTextField txtNome = new JTextField();
		JTextField txtPeso = new JTextField();
		JTextField txtAltura = new JTextField();


		
		// Radiobuttons

		JRadioButton rbtnHomem = new JRadioButton();
		rbtnHomem.setBackground(yellow);
		
		JRadioButton rbtnMulher = new JRadioButton();
		rbtnMulher.setBackground(yellow);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));

		// ------- CRIANDO UMA COMBOBOX -------

		// Combobox
		JComboBox<String> comboNivelAtividade = new JComboBox<String>();

		// Vetor para níveis de atividade
		String[] nivelAtividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		// Modelo para ser inserido no ComboBox
		DefaultComboBoxModel<String> modelAtividade = new DefaultComboBoxModel<>(nivelAtividade);

		// Setando o modelo ao combo criado anteriormente
		comboNivelAtividade.setModel(modelAtividade);

		// Criando um grupo de botões, apenas um pode ser selecionado !!!
		ButtonGroup grupo = new ButtonGroup();

		grupo.add(rbtnMulher);

		grupo.add(rbtnHomem);
		panelDados.setBackground(yellow);
		panelTitulo.setBackground(gray);

		// Criando uma fonte
		Font font = new Font("Arial", 0, 10);
		Font fontTitulo = new Font("Arial", 0, 30);

		
		lblSexo.setBounds(294, 59, 45, 20);
		lblPeso.setBounds(10, 112, 45, 20);

		
		lblAltura.setBounds(226, 112, 45, 20);

		lblData.setBounds(10, 152, 129, 20);
		
		lblQuilos.setBounds(156, 112, 60, 20);
		lblCents.setBounds(372, 112, 45, 20);

		lblHomem.setBounds(352, 59, 45, 20);
		lblMulher.setBounds(433, 59, 45, 20);
		

		lblNivel.setBounds(10, 183, 105, 27);

		//Titulo Boa Forma
		lblTitulo.setBounds(10, 0, 250, 100);
		lblTitulo.setForeground(blue);

		lblTitulo.setIcon(iconLogo);
		
		lblTitulo.setFont(fontTitulo);
		
		// Tamanho e posicionamento de cada TextField
		txtNome.setBounds(60, 60, 204, 20);
		txtPeso.setBounds(60, 112, 86, 20);
		txtAltura.setBounds(276, 112, 86, 20);

		// posicionando radiobuttons
		rbtnHomem.setBounds(331, 59, 20, 20);
		rbtnMulher.setBounds(409, 59, 20, 20);

		// tamanho e posicionamento dos buttons
		btnCalcular.setBounds(177, 220, 115, 35);
		
		//Colocando icon dentro do button
		btnCalcular.setIcon(iconCalc);

		// tamanho e posicionament do comboBox
		comboNivelAtividade.setBounds(125, 184, 146, 27);

		// Layout dos painéis
		panelDados.setLayout(null);
	
		panelTitulo.setLayout(null);
		panelDados.add(lblSexo);
		panelDados.add(lblPeso);
		panelDados.add(lblAltura);
		panelDados.add(lblData);

		panelDados.add(lblQuilos);
		panelDados.add(lblCents);

		panelDados.add(lblHomem);
		panelDados.add(lblMulher);

		panelDados.add(lblNivel);

		panelDados.add(txtNome);
		panelDados.add(txtPeso);
		panelDados.add(txtAltura);

		panelDados.add(rbtnHomem);
		panelDados.add(rbtnMulher);

		panelDados.add(btnCalcular);

		panelDados.add(comboNivelAtividade);

		// Borda dos painéis
		panelDados.setBorder(bordaDados);

		//Adicionando elemento
		panelTitulo.add(lblTitulo);
		getContentPane().setLayout(null);
		

		// Adicionando paineis especificos ao painel de conteúdo
		getContentPane().add(panelDados);
		
		//Atribuindo um formato para o txtData
		MaskFormatter dataMask = null;
		
		
			//Instanciando o objeto
			try {
				dataMask = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		JFormattedTextField txtData = new JFormattedTextField(dataMask);
		txtData.setBounds(138, 153, 93, 20);
		panelDados.add(txtData);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 60, 45, 20);
		panelDados.add(lblNome);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 35, 46, 14);
		panelDados.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(40, 33, 68, 20);
		panelDados.add(txtID);
		txtID.setColumns(10);
		getContentPane().add(panelTitulo);
		
		JLabel lblOperacao = new JLabel("op");
		lblOperacao.setForeground(Color.RED);
		lblOperacao.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblOperacao.setBounds(338, 50, 101, 22);
		panelTitulo.add(lblOperacao);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(0, 365, 488, 193);
		panelResultados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelResultados.setLayout(null);
		panelResultados.setBackground(new Color(229, 227, 135));
		getContentPane().add(panelResultados);
		
		JLabel lblIMC = new JLabel("IMC: ");
		lblIMC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIMC.setBounds(10, 38, 34, 20);
		panelResultados.add(lblIMC);
		
		JLabel lblResultIMC = new JLabel("...");
		lblResultIMC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultIMC.setBounds(45, 38, 90, 20);
		panelResultados.add(lblResultIMC);
		
		JLabel lblTMB = new JLabel("TMB: ");
		lblTMB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTMB.setBounds(10, 120, 34, 20);
		panelResultados.add(lblTMB);
		
		JLabel lblResultTMB = new JLabel("...");
		lblResultTMB.setForeground(new Color(34, 170, 95));
		lblResultTMB.setBounds(45, 121, 90, 20);
		panelResultados.add(lblResultTMB);
		
		JLabel lblFCM = new JLabel("FCM: ");
		lblFCM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFCM.setBounds(10, 151, 34, 20);
		panelResultados.add(lblFCM);
		
		JLabel lblResultFMC = new JLabel("...");
		lblResultFMC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultFMC.setBounds(45, 152, 90, 20);
		panelResultados.add(lblResultFMC);
		lblResultFMC.setForeground(new Color(34, 170, 95));
		
		JLabel lblNivelAtividade = new JLabel("N\u00EDvel de Atividade:  ");
		lblNivelAtividade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNivelAtividade.setBackground(new Color(34, 170, 95));
		lblNivelAtividade.setBounds(10, 11, 117, 27);
		panelResultados.add(lblNivelAtividade);
		
		JLabel lblResultAti = new JLabel("...  ");
		lblResultAti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultAti.setForeground(new Color(34, 170, 95));
		lblResultAti.setBounds(124, 11, 228, 27);
		panelResultados.add(lblResultAti);
		
		JScrollPane scrollPaneIIMC = new JScrollPane();
		scrollPaneIIMC.setBounds(10, 56, 468, 53);
		panelResultados.add(scrollPaneIIMC);
		
		JList listIMC = new JList();
		listIMC.setModel(new AbstractListModel() {
			String[] values = new String[] {"...", "..."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listIMC.setValueIsAdjusting(true);
		scrollPaneIIMC.setViewportView(listIMC);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(306, 15, 86, 20);
		panelResultados.add(txtIdade);
		txtIdade.setColumns(10);
		
		JPanel panelBotao = new JPanel();
		panelBotao.setBackground(new Color(229, 227, 135));
		panelBotao.setBounds(0, 558, 488, 91);
		getContentPane().add(panelBotao);
		panelBotao.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(FrmCliente2.class.getResource("/br/senai/sp/jandira/Imagens/save.png")));
		btnSalvar.setBounds(10, 24, 71, 56);
		panelBotao.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(FrmCliente2.class.getResource("/br/senai/sp/jandira/Imagens/close_app.png")));
		btnCancelar.setBounds(407, 24, 71, 56);
		panelBotao.add(btnCancelar);
		

		// Criando objeto da classe ClienteAcademia
		Cliente cliente = new Cliente();
		
		
		// Eventos para os cálculos
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Setando valores dos atributos do cliente
				cliente.setNome(txtNome.getText());
//				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
//				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				//cliente.setIdade(txtIdade.getText());
				
				cliente.setNivelAtividade(String.valueOf(comboNivelAtividade.getSelectedItem()));
				
				//cliente.setTaxaNivel(cliente.calcularTaxaNivel(cliente.getNivelAtividade()));
				
				//Dados retornados
				lblResultAti.setText(String.valueOf(cliente.getNivelAtividade()));
				
				

				
				// Resultado do IMC deverá aparecer aqui
//				cliente.setImc(cliente.calcularIMC(cliente.getPeso(), cliente.getAltura()));
				
				lblResultIMC.setText(String.valueOf(cliente.getImc()));
				
//				//classificação e sintomas do cliente
//				//cliente.validarClassificacao(cliente.getImc(), String.valueOf(listIMC.getSelectedIndex()));
//				
//				//cliente.validarSintomas(cliente.getImc(), String.valueOf(listIMC.getSelectedIndex()));
//
//				//calculando a taxa de nivel de atividade do cliente
//				
//							
//				//calculo do tmb
//				
//				cliente.setTmb(cliente.calcularTMB(cliente.getPeso(), cliente.getAltura(), cliente.getIdade(),
//						cliente.getTaxaNivel(), rbtnHomem.isSelected()));
//				
//				lblResultTMB.setText(String.valueOf(cliente.getTmb()));
//				
//				//calculo do fcm
//				lblResultFMC.setText(String.valueOf(cliente.calcularFCM(cliente.getIdade(), cliente.getPeso(), rbtnHomem.isSelected())));
			}
		});
	}
}
