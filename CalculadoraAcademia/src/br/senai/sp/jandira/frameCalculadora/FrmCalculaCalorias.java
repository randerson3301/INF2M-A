package br.senai.sp.jandira.frameCalculadora;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import java.awt.Color;

import br.senai.sp.jandira.CalculadoraAcademia.ClienteAcademia;

//Herança da classe JFrame
public class FrmCalculaCalorias extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// contrutor da classe
	public FrmCalculaCalorias() {

		// Colors
		Color yellow = new Color(229, 227, 135);
		Color green = new Color(34, 170, 95);
		Color gray = new Color(214, 214, 214);
		Color blue = new Color(50, 50, 255);

		//Colocando icone para a imagem
		ImageIcon iconCalc = new ImageIcon(FrmCalculaCalorias.class.getResource("/br/senai/sp/jandira/Imagens/calc1.png"));
		ImageIcon iconLogo = new ImageIcon(FrmCalculaCalorias.class.getResource("/br/senai/sp/jandira/Imagens/logo.png"));
		
		// Tamanho da tela
		setSize(650, 440);

		// Titulo da janela
		setTitle("Calculadora de Calorias");

		// Layout
		setLayout(null);

		// método para encerrar o programa
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		// Criando objetos que irão compor a frame
		JPanel panelDados = new JPanel();
		JPanel panelResultados = new JPanel();
		JPanel panelTitulo = new JPanel();
		

		TitledBorder bordaDados = new TitledBorder("Dados: ");
		TitledBorder bordaResultados = new TitledBorder("Resultados: ");

		JLabel lblNome = new JLabel("Nome: ");
		
		JLabel lblNome2 = new JLabel("Nome: ");
		JLabel lblResultNome = new JLabel("...");
		lblResultNome.setBackground(green);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		
		JLabel lblPeso2 = new JLabel("Peso: ");
		JLabel lblPeso = new JLabel("Peso: ");
		JLabel lblResultPeso = new JLabel("...");
		lblResultPeso.setBackground(green);
		
		JLabel lblAltura = new JLabel("Altura: ");

		JLabel lblAltura2 = new JLabel("Altura: ");
		JLabel lblResultAlt = new JLabel("...");
		lblResultAlt.setBackground(green);
		
		JLabel lblIdade = new JLabel("Idade: ");

		JLabel lblIdade2 = new JLabel("Idade: ");
		JLabel lblResultIdade = new JLabel("...");
		lblResultIdade.setBackground(green);

		JLabel lblQuilos = new JLabel("quilos(kg)");
		JLabel lblCents = new JLabel("cm");
		JLabel lblAnos = new JLabel("anos");

		JLabel lblHomem = new JLabel("Homem");
		JLabel lblMulher = new JLabel("Mulher");

		JLabel lblNivelAtividade = new JLabel("Nível de Atividade:  ");
		JLabel lblNivelAtividadeResult = new JLabel("...  ");
		lblNivelAtividade.setBackground(green);

		
		JLabel lblIMC = new JLabel("IMC: ");
		JLabel lblResultIMC = new JLabel("...");

		JLabel lblClassificacao = new JLabel();
		JLabel lblSintomas = new JLabel();

		JLabel lblTMB = new JLabel("TMB: ");
		JLabel lblResultTMB = new JLabel("...");

		JLabel lblFCM = new JLabel("FCM: ");
		JLabel lblResultFCM = new JLabel("...");

		JLabel lblNivel = new JLabel("Nível de Atividade");
		JLabel lblTitulo = new JLabel("Boa Forma");

		JTextField txtNome = new JTextField();
		JTextField txtPeso = new JTextField();
		JTextField txtAltura = new JTextField();
		JTextField txtIdade = new JTextField();


		
		// Radiobuttons

		JRadioButton rbtnHomem = new JRadioButton();
		rbtnHomem.setBackground(yellow);
		
		JRadioButton rbtnMulher = new JRadioButton();
		rbtnMulher.setBackground(yellow);

		JButton btnCalcular = new JButton("Calcular");

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

		// -------POSICIONAMENTO E TAMANHO DE CADA OBJETO--------

		// Definindo tamanho e posicionamento dos painéis
		panelDados.setBounds(0, 100, 270, 300);
		panelDados.setBackground(yellow);
		
		panelResultados.setBounds(270, 100, 360, 300);
		panelResultados.setBackground(yellow);

		panelTitulo.setBounds(0, 0, 650, 100);
		panelTitulo.setBackground(gray);

		// Criando uma fonte
		Font font = new Font("Arial", 0, 10);
		Font fontTitulo = new Font("Arial", 0, 30);
		
		// Tamanho e posicionamento das labels
		
		lblNome.setBounds(50, 10, 400, 70);

		lblNome.setBounds(10, 35, 45, 20);
		lblNome2.setBounds(10, 25, 45, 20);
		lblResultNome.setBounds(60, 25, 70, 20);
		lblResultNome.setForeground(green);

		
		lblSexo.setBounds(10, 60, 45, 20);
		lblPeso.setBounds(10, 85, 45, 20);
		lblPeso2.setBounds(10, 100, 100, 20);
		lblResultPeso.setBounds(60, 100, 45, 20);
		lblResultPeso.setForeground(green);

		
		lblAltura.setBounds(10, 110, 45, 20);
		lblAltura2.setBounds(10, 75, 45, 20);
		lblResultAlt.setBounds(60, 75, 100, 20);
		lblResultAlt.setForeground(green);

		lblIdade.setBounds(10, 135, 45, 20);
		lblIdade2.setBounds(10, 50, 45, 20);
		lblResultIdade.setBounds(60, 50, 130, 20);
		lblResultIdade.setForeground(green);
		
		lblQuilos.setBounds(135, 85, 60, 20);
		lblCents.setBounds(135, 110, 45, 20);
		lblAnos.setBounds(135, 135, 45, 20);

		lblHomem.setBounds(90, 60, 45, 20);
		lblMulher.setBounds(175, 60, 45, 20);

		lblIMC.setBounds(10, 150, 45, 20);
		lblResultIMC.setBounds(45, 150, 90, 20);
		
		
		lblClassificacao.setBounds(0, 0, 280, 20);
		lblClassificacao.setFont(font);

		lblSintomas.setBounds(0, 20, 340, 20);
		lblSintomas.setFont(font);

		lblTMB.setBounds(10, 215, 45, 20);
		lblResultTMB.setBounds(45, 215, 90, 20);
		lblResultTMB.setForeground(green);
		
		lblFCM.setBounds(10, 245, 45, 20);
		lblResultFCM.setBounds(45, 245, 90, 20);
		

		lblNivel.setBounds(10, 168, 105, 27);
		
		lblNivelAtividade.setBounds(10, 125, 125, 27);
		lblNivelAtividadeResult.setBounds(135, 125, 125, 27);
		lblNivelAtividadeResult.setForeground(green);

		//Titulo Boa Forma
		lblTitulo.setBounds(40, -1, 250, 100);
		lblTitulo.setForeground(blue);

		lblTitulo.setIcon(iconLogo);
		
		lblTitulo.setFont(fontTitulo);
		
		// Tamanho e posicionamento de cada TextField
		txtNome.setBounds(60, 35, 140, 20);
		txtPeso.setBounds(60, 85, 65, 20);
		txtAltura.setBounds(60, 110, 65, 20);
		txtIdade.setBounds(60, 135, 65, 20);

		// posicionando radiobuttons
		rbtnHomem.setBounds(60, 60, 20, 20);
		rbtnMulher.setBounds(150, 60, 20, 20);

		// tamanho e posicionamento dos buttons
		btnCalcular.setBounds(90, 240, 115, 35);
		
		//Colocando icon dentro do button
		btnCalcular.setIcon(iconCalc);

		// tamanho e posicionament do comboBox
		comboNivelAtividade.setBounds(10, 190, 160, 27);

		// Layout dos painéis
		panelDados.setLayout(null);
		panelResultados.setLayout(null);
	
		panelTitulo.setLayout(null);

		// Criando um painel para os Sintomas e classificação
		JPanel panelIMC = new JPanel();
		panelIMC.setLayout(null);
		
		panelIMC.setBounds(10, 170, 340, 40);
		
		panelIMC.add(lblSintomas);
		panelIMC.add(lblClassificacao);
		
		
		
		

		// Adicionando conteúdo ao painel de dados
		panelDados.add(lblNome);
		panelDados.add(lblSexo);
		panelDados.add(lblPeso);
		panelDados.add(lblAltura);
		panelDados.add(lblIdade);

		panelDados.add(lblQuilos);
		panelDados.add(lblCents);
		panelDados.add(lblAnos);

		panelDados.add(lblHomem);
		panelDados.add(lblMulher);

		panelDados.add(lblNivel);

		panelDados.add(txtNome);
		panelDados.add(txtPeso);
		panelDados.add(txtAltura);
		panelDados.add(txtIdade);

		panelDados.add(rbtnHomem);
		panelDados.add(rbtnMulher);

		panelDados.add(btnCalcular);

		panelDados.add(comboNivelAtividade);

		// Borda dos painéis
		panelDados.setBorder(bordaDados);
		panelResultados.setBorder(bordaResultados);

		// Adicionar elementos ao painel de resultados
		panelResultados.add(lblNome2);
		panelResultados.add(lblResultNome);
		
		panelResultados.add(lblIdade2);
		panelResultados.add(lblResultIdade);
		
		panelResultados.add(lblPeso2);
		panelResultados.add(lblResultPeso);
		
		panelResultados.add(lblAltura2);
		panelResultados.add(lblResultAlt);
		
		panelResultados.add(lblIMC);
		panelResultados.add(lblResultIMC);

		panelResultados.add(lblTMB);
		panelResultados.add(lblResultTMB);

		panelResultados.add(lblFCM);
		panelResultados.add(lblResultFCM);

		panelResultados.add(lblNivelAtividade);
		panelResultados.add(lblNivelAtividadeResult);
		
		panelResultados.add(panelIMC);

		//Adicionando elemento
		panelTitulo.add(lblTitulo);
		

		// Adicionando paineis especificos ao painel de conteúdo
		getContentPane().add(panelDados);
		getContentPane().add(panelResultados);
		getContentPane().add(panelTitulo);

		// Visibilidade da tela
		setVisible(true);

		// Criando objeto da classe ClienteAcademia
		ClienteAcademia cliente = new ClienteAcademia();
		
		
		// Eventos para os cálculos
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Setando valores dos atributos do cliente
				cliente.setNome(txtNome.getText());
				cliente.setIdade(Double.parseDouble(txtIdade.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				
				cliente.setNivelAtividade(String.valueOf(comboNivelAtividade.getSelectedItem()));
				
				cliente.setTaxaNivel(cliente.calcularTaxaNivel(cliente.getNivelAtividade()));
				
				//Dados retornados
				lblResultNome.setText(cliente.getNome());
				
				lblResultIdade.setText(String.valueOf(cliente.getIdade()));
				
				lblResultAlt.setText(String.valueOf(cliente.getAltura()));
				
				lblResultPeso.setText(String.valueOf(cliente.getPeso()));
				
				lblNivelAtividadeResult.setText(String.valueOf(cliente.getNivelAtividade()));
				
				//Retornando sintomas e classificação do cliente
				lblClassificacao.setText(cliente.validarClassificacao(cliente.calcularIMC(cliente.getPeso(), cliente.getAltura()), lblClassificacao.getText()));
				
				lblSintomas.setText(cliente.validarSintomas(cliente.calcularIMC(cliente.getPeso(), cliente.getAltura()), lblSintomas.getText()));

				
				// Resultado do IMC deverá aparecer aqui
				cliente.setImc(cliente.calcularIMC(cliente.getPeso(), cliente.getAltura()));
				
				lblResultIMC.setText(String.valueOf(cliente.getImc()));
				
				//classificação e sintomas do cliente
				cliente.validarClassificacao(cliente.getImc(), lblClassificacao.getText());
				
				cliente.validarSintomas(cliente.getImc(), lblSintomas.getText());

				//calculando a taxa de nivel de atividade do cliente
				
				
				lblNivelAtividadeResult.setText(cliente.getNivelAtividade());
				
				//calculo do tmb
				
				cliente.setTmb(cliente.calcularTMB(cliente.getPeso(), cliente.getAltura(), cliente.getIdade(),
						cliente.getTaxaNivel(), rbtnHomem.isSelected()));
				
				lblResultTMB.setText(String.valueOf(cliente.getTmb()));
				
				//calculo do fcm
				lblResultFCM.setText(String.valueOf(cliente.calcularFCM(cliente.getIdade(), cliente.getPeso(), rbtnHomem.isSelected())));
			}
		});
	}
}
