package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JPanel panelTabela;

	/**
	 * Create the frame.
	 */
	public FrmAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 551);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		setTitle("Agenda de Contatos");

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.BLACK);
		painelTitulo.setBounds(0, 0, 409, 67);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel("Agenda De Contatos");
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 389, 67);
		painelTitulo.add(lblTitulo);

		panelTabela = new JPanel();
		panelTabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Meus Contatos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelTabela.setBounds(10, 92, 389, 321);
		painelPrincipal.add(panelTabela);
		panelTabela.setLayout(null);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelBotoes.setBounds(10, 424, 389, 77);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/add_user.png")));
		btnNovo.setToolTipText("Adicionar um novo contato");
		btnNovo.setBounds(10, 12, 57, 54);
		painelBotoes.add(btnNovo);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/edit_user.png")));

		btnEditar.setToolTipText("Editar contato");
		btnEditar.setBounds(77, 12, 57, 54);
		painelBotoes.add(btnEditar);

		criarTabela();

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/delete_user.png")));
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setBounds(144, 12, 57, 54);
		painelBotoes.add(btnExcluir);

		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/close_app.png")));
		btnSair.setToolTipText("Sair do programa");
		btnSair.setBounds(310, 12, 57, 54);
		painelBotoes.add(btnSair);

		JLabel lblData = new JLabel("Data Atual");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(203, 74, 178, 20);

		// ***Ajustando hora***
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Date dataAtual = new Date();

		lblData.setText("Hoje é: " + df.format(dataAtual));

		painelPrincipal.add(lblData);

		// Eventos
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContato contato = new FrmContato("Adicionar", "Adicionar Contato");
				contato.setVisible(true);
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				receberDados("Editar");
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				receberDados("Excluir");
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});

	}

	public void criarTabela() {

		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 360, 288);
		panelTabela.add(scrollTabela);

		tabelaContatos = new JTable();
		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO dao = new ContatoDAO();

		contatos = dao.getListaContatos();

		// ********TITULO DA TABELA*********
		DefaultTableModel modeloTabela = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		String[] nomeColunas = { "ID", "Nome", "E-mail" };
		modeloTabela.setColumnIdentifiers(nomeColunas);

		// ******DADOS DA TABELA**********
		Object[] linha = new Object[3];

		for (Contato contato : contatos) {
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();

			modeloTabela.addRow(linha);

		}

		tabelaContatos.setModel(modeloTabela);

		// ***Travando a movimentação de colunas*****
		tabelaContatos.getTableHeader().setReorderingAllowed(false);

		// ******FORMATANDO AS COLUNAS DA TABELA*****
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(0).setResizable(false);

		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabelaContatos.getColumnModel().getColumn(1).setResizable(false);

		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(170);
		tabelaContatos.getColumnModel().getColumn(2).setResizable(false);

		scrollTabela.setViewportView(tabelaContatos);

	}

	// --------------------------------------------------------------------------------------------------------

	// Fará a tela da aplicação receber os dados do registro selecionado
	public void receberDados(String op) {
		FrmContato frmContato = new FrmContato(op, op + " Contato");

		// ********Recuperar ID selecionado************

		try {
			int linha = tabelaContatos.getSelectedRow();

			int id = (int) tabelaContatos.getValueAt(linha, 0);

			ContatoDAO dao = new ContatoDAO();

			Contato contato = new Contato();
			contato = dao.getContato(id);

			Date dtAtual = new Date();

			frmContato.setTxtID(contato.getId());

			frmContato.setTxtNome(contato.getNome());
			frmContato.setTxtCelular((contato.getCelular()));
			frmContato.setTxtData(contato.getDtNasc());
			frmContato.setTxtEmail(contato.getEmail());
			frmContato.setTxtTelefone(contato.getTelefone());
			frmContato.setTxtEndereco(contato.getEndereco());
			frmContato.setCbSexo(contato.getSexo());

			frmContato.setVisible(true);

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null, "Por favor, selecione um contato.", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}
}
