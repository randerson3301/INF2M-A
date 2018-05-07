package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class FrmContato extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtEmail;
	// private JTextField txtData;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JComboBox cbSexo;
	private JTextArea txtEndereco;
	//private JComboBox ;
	private JFormattedTextField txtData;

	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));
		;
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

	public void setTxtData(String data) {
		this.txtData.setText(data);
	}

	public void setTxtTelefone(String telefone) {
		this.txtTelefone.setText(telefone);
	}

	public void setTxtCelular(String celular) {
		this.txtCelular.setText(celular);
	}

	public void setCbSexo(String sexo) {

		if (sexo.equals("M")) {
			cbSexo.setSelectedIndex(1);
		} else {
			cbSexo.setSelectedIndex(0);
		}
	}

	public void setTxtEndereco(String endereco) {
		this.txtEndereco.setText(String.valueOf(endereco));
	}

	/**
	 * Create the frame.
	 */
	public FrmContato(String operacao, String titulo) {
		setTitle(titulo);
		setBounds(100, 100, 458, 551);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.LIGHT_GRAY);
		panelTitulo.setBounds(0, 0, 442, 62);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setForeground(new Color(0, 0, 0));
		lblContatos.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/contact.png")));
		lblContatos.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblContatos.setBounds(20, 11, 195, 40);
		panelTitulo.add(lblContatos);

		JLabel lblOperacao = new JLabel(operacao);

		lblOperacao.setForeground(Color.BLACK);
		lblOperacao.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblOperacao.setBounds(279, 25, 99, 20);
		panelTitulo.add(lblOperacao);

		JPanel panelDados = new JPanel();
		panelDados.setBorder(
				new TitledBorder(null, "Dados do Contato", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panelDados.setBounds(20, 73, 412, 376);
		panelPrincipal.add(panelDados);
		panelDados.setLayout(null);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(10, 41, 46, 25);
		panelDados.add(txtID);
		txtID.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNome.setBounds(85, 25, 61, 14);
		panelDados.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(85, 41, 317, 25);
		panelDados.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblEmail.setBounds(10, 91, 61, 14);
		panelDados.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 107, 260, 25);
		panelDados.add(txtEmail);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSexo.setBounds(304, 91, 61, 14);
		panelDados.add(lblSexo);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Feminino", "Masculino" }));
		cbSexo.setBounds(298, 109, 104, 20);
		panelDados.add(cbSexo);

		JLabel lblData = new JLabel("Data De Nascimento:");
		lblData.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblData.setBounds(10, 145, 146, 14);
		panelDados.add(lblData);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTelefone.setBounds(166, 145, 74, 14);
		panelDados.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(166, 161, 104, 25);
		panelDados.add(txtTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCelular.setBounds(298, 145, 74, 14);
		panelDados.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(298, 161, 104, 25);
		panelDados.add(txtCelular);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 392, 146);
		panelDados.add(scrollPane);

		txtEndereco = new JTextArea();
		txtEndereco.setLineWrap(true);
		scrollPane.setViewportView(txtEndereco);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 194, 146, 14);
		panelDados.add(lblEndereco);

		JLabel label = new JLabel("");
		label.setBounds(314, 112, 46, 14);
		panelDados.add(label);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblId.setBounds(10, 25, 46, 14);
		panelDados.add(lblId);

		// ***********Criando Mask Format*****************
		MaskFormatter dataMask = null;

		try {

			dataMask = new MaskFormatter("##/##/####");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtData = new JFormattedTextField(dataMask);
		txtData.setBounds(10, 163, 136, 23);
		panelDados.add(txtData);

		JButton btnSalvar = new JButton("");

		// ***********Evento Salvar*****
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");

				// Para o access reconhecer a data
				SimpleDateFormat toDatabase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");

				Date date = null;

				String dataAccess = "";

				try {
					date = toDate.parse(txtData.getText());
					dataAccess = toDatabase.format(date);

					Contato cont = new Contato(); // Primeiramente cria-se um
					// contato.

					cont.setNome(txtNome.getText());

					cont.setDtNasc(dataAccess);

					cont.setEmail(txtEmail.getText());

					cont.setCelular(txtCelular.getText());

					cont.setTelefone(txtTelefone.getText());

					cont.setSexo((cbSexo.getSelectedItem().toString().substring(0, 1)));

					ContatoDAO contDao = new ContatoDAO();
					contDao.setContato(cont);

					// Decisão
					if (lblOperacao.getText().equals("Adicionar")) {
						contDao.gravar();
						limparCampos();

					} else if (lblOperacao.getText().equals("Editar")) {
						cont.setId(Integer.parseInt(txtID.getText()));
						contDao.atualizar();

					} else if (lblOperacao.getText().equals("Excluir")) {
						cont.setId(Integer.parseInt(txtID.getText()));
						
						int teste = JOptionPane.showConfirmDialog(null, "Deseja excluir o contato ?", "Confirmação", 
								JOptionPane.OK_OPTION, JOptionPane.CLOSED_OPTION);
						
						if(teste == JOptionPane.OK_OPTION) {
							contDao.excluir();
						} else {
							JOptionPane.showMessageDialog(null, "O contato não foi excluido", 
									"Info", JOptionPane.INFORMATION_MESSAGE);
						}
					}

				} catch (ParseException e) {

					e.printStackTrace();

					JOptionPane.showMessageDialog(null, "A data está incorreta!", "Erro de conversão",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnSalvar.setToolTipText("Salvar Contato");
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setBounds(20, 460, 63, 41);
		panelPrincipal.add(btnSalvar);

		JButton btnSair = new JButton("");

		btnSair.setToolTipText("Cancelar");
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/cancel.png")));
		btnSair.setForeground(Color.BLACK);
		btnSair.setBounds(369, 460, 63, 41);
		panelPrincipal.add(btnSair);
	}

	private void limparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtData.setText("");
		txtTelefone.setText("");
		txtCelular.setText("");
		cbSexo.setSelectedIndex(0);
		txtEndereco.setText("");

		txtNome.grabFocus();

	}
}
