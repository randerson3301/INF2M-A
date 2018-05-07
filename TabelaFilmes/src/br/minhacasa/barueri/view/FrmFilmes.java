package br.minhacasa.barueri.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;

import br.minhacasa.barueri.dao.FilmeDAO;
import br.minhacasa.barueri.model.Filme;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFilmes extends JFrame {

	private JPanel panelPrincipal;
	private JTable tableFilmes;
	private JPanel panelTabela;

	/**
	 * Create the frame.
	 */
	public FrmFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(51, 153, 255));
		panelTitulo.setBounds(0, 0, 734, 38);
		panelPrincipal.add(panelTitulo);

		panelTabela = new JPanel();
		panelTabela.setBorder(
				new TitledBorder(null, "Meus Filmes", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panelTabela.setBounds(10, 49, 714, 248);
		panelPrincipal.add(panelTabela);
		panelTabela.setLayout(null);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 308, 714, 53);
		panelPrincipal.add(panelBotoes);
		panelBotoes.setLayout(null);

		JButton btnNovo = new JButton("");

		btnNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				FrmFilme filme = new FrmFilme("Adicionar");
				filme.setVisible(true);
			}
		});
		btnNovo.setForeground(Color.DARK_GRAY);
		btnNovo.setToolTipText("Adiciona um novo filme");
		btnNovo.setIcon(new ImageIcon(FrmFilmes.class.getResource("/br/minhacasa/barueri/imagens/add-movie.png")));
		btnNovo.setBounds(10, 5, 59, 42);
		panelBotoes.add(btnNovo);

		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getDados("Editar");
			}
		});
		btnEditar.setToolTipText("Editar filme");
		btnEditar.setIcon(new ImageIcon(FrmFilmes.class.getResource("/br/minhacasa/barueri/imagens/edit-movie.png")));
		btnEditar.setBounds(79, 5, 59, 42);
		panelBotoes.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDados("Excluir");
			}
		});
		btnExcluir.setToolTipText("Excluir filme");
		btnExcluir.setIcon(new ImageIcon(FrmFilmes.class.getResource("/br/minhacasa/barueri/imagens/del-movie.png")));
		btnExcluir.setBounds(152, 5, 59, 42);
		panelBotoes.add(btnExcluir);

		criarTabela();

	}

	public void criarTabela() {
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 690, 215);
		panelTabela.add(scrollTabela);
		
		Color red = new Color(255, 50, 100);
		Color white = new Color(255, 255, 255);
		Color green = new Color(0, 255, 0);

		tableFilmes = new JTable();
		ArrayList<Filme> filmes = new ArrayList<>();

		FilmeDAO dao = new FilmeDAO();

		filmes = dao.getListaFilmes();

		// COLOCANDO UM TITLE NA TABELA
		DefaultTableModel modelTabela = new DefaultTableModel() {
			// Proibindo a edição da tabela
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		String[] nomeColunas = { "ID", "Titulo", "Data de Lançamento", "Diretor", "Já Vi?" };

		modelTabela.setColumnIdentifiers(nomeColunas);

		// Inserindo dados na tabela
		Object[] linha = new Object[5];
		
		

		for (Filme filme : filmes) { // filmes é o ArrayList
			linha[0] = filme.getId();
			linha[1] = filme.getTitulo();
			linha[2] = filme.getDtLancamento();
			linha[3] = filme.getDiretor();
			linha[4] = filme.getVisto();
			
			
			tableFilmes.setRowHeight(20, 20);;
			
			modelTabela.addRow(linha);
			
			
		}

		tableFilmes.setModel(modelTabela);

		// ********TRAVANDO MOVIMENTAÇÃO NA TABELA*******
		tableFilmes.getTableHeader().setReorderingAllowed(false);

		// ****Formatando as colunas da tabela
		tableFilmes.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableFilmes.getColumnModel().getColumn(0).setResizable(false);

		tableFilmes.getColumnModel().getColumn(1).setPreferredWidth(154);
		tableFilmes.getColumnModel().getColumn(1).setResizable(false);

		tableFilmes.getColumnModel().getColumn(2).setPreferredWidth(154);
		tableFilmes.getColumnModel().getColumn(2).setResizable(false);

		tableFilmes.getColumnModel().getColumn(3).setPreferredWidth(154);
		tableFilmes.getColumnModel().getColumn(3).setResizable(false);
		
		tableFilmes.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableFilmes.getColumnModel().getColumn(4).setResizable(false);
		

		scrollTabela.setViewportView(tableFilmes);
	}

	// método para receber dados
	public void getDados(String op) {
		/*
		 * Esse método será usado para inserir os dados do filme dentro da tela de
		 * filmes.
		 */

		FrmFilme frmFilme = new FrmFilme(op);

		// Receber ID selecionado

		try {
			int linha = tableFilmes.getSelectedRow();

			int teste = (int) tableFilmes.getValueAt(linha, 0);

			FilmeDAO dao = new FilmeDAO();

			Filme filme = new Filme();

			filme = dao.getFilmeDados(teste);

			//setando valores
			frmFilme.setTxtID(filme.getId());

			frmFilme.setTxtTitulo(filme.getTitulo());

			frmFilme.setTxtAno(filme.getDtLancamento());

			frmFilme.setTxtDiretor(filme.getDiretor());

			frmFilme.setTxtSinopse(filme.getSinopse());

			frmFilme.setTxtTempo(filme.getDuracao());

			frmFilme.setTxtGenero(filme.getGenero());

			frmFilme.setCbVisto(filme.getVisto());

			frmFilme.setVisible(true);

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null, "Por favor, selecione um filme. ", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
		
}
