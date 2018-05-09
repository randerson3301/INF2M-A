package br.senai.sp.jandira.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class FrmAcademia extends JFrame {

	private JPanel panelPrincipal;
	private final JPanel panelTitulo = new JPanel();
	private JTable tableClientes;
	private JButton btnAtualizar;
	
	//chamando o objeto DAO do Cliente
	private ClienteDAO dao;

	/**
	 * Create the frame.
	 */
	public FrmAcademia() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 559);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(155, 194, 255));
		panelTitulo.setBackground(new Color(14, 66, 147));
		panelTitulo.setBounds(0, 0, 548, 73);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel("Boa Forma");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/logoGym.png")));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setBounds(33, 0, 213, 73);
		panelTitulo.add(lblTitulo);

		

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBotoes.setBounds(10, 425, 528, 84);
		panelPrincipal.add(panelBotoes);
		panelBotoes.setBackground(new Color(155, 194, 255));
		panelBotoes.setLayout(null);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			
			//Evento do botão adicionar
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente frmCliente = new FrmCliente("Adicionar", "Adicionar" );
				
				frmCliente.setVisible(true);
				
			}
		});
		btnAdicionar.setToolTipText("Adicionar Cliente");
		btnAdicionar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/add-client.png")));
			
		btnAdicionar.setBounds(10, 11, 74, 62);
		panelBotoes.add(btnAdicionar);

		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				receberDados("Editar");
				
				
			}
		});
		btnEditar.setToolTipText("Editar Cliente");
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		btnEditar.setBounds(99, 11, 74, 62);
		panelBotoes.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receberDados("Excluir");
			}
		});
		btnExcluir.setToolTipText("Excluir Cliente");
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/delete.png")));
		btnExcluir.setBounds(187, 11, 74, 62);
		panelBotoes.add(btnExcluir);

		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair do programa");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/cancel.png")));
		btnSair.setBounds(433, 11, 74, 62);
		panelBotoes.add(btnSair);
		
		btnAtualizar = new JButton("");
		
		btnAtualizar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/update-icon.png")));
		btnAtualizar.setToolTipText("Atualizar Tabela");
		btnAtualizar.setBounds(279, 11, 74, 62);
		panelBotoes.add(btnAtualizar);
		
		criarTabela();
		
		
	}
	
	public void criarTabela() {
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 97, 528, 317);
		panelPrincipal.add(scrollTabela);

		tableClientes = new JTable();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		 dao = new ClienteDAO();
		
		//ArrayList recebe o contatoDAO
		clientes = dao.getListaClientes();
		
		//Proibindo a edição dos campos
		DefaultTableModel modelTabela = new DefaultTableModel() {
			public boolean isCellEditable(int col, int row) {
				return false;
			}
			
		};
		
		
		
		//Adicionando nomes as colunas que serão criadas
		String[] nomeColunas = {"ID", "Nome"};
		
		modelTabela.setColumnIdentifiers(nomeColunas);
		
		//Recebendo os dados do banco
		Object[] linha = new Object[2];
		
		for(Cliente cliente : clientes) {
			linha[0] = cliente.getId();
			
			linha[1] = cliente.getNome();
			
			modelTabela.addRow(linha);
			
			
		}
		
		//Setando o modelo a tabela
		tableClientes.setModel(modelTabela);
		
		//Proibindo a movimentação
		tableClientes.getTableHeader().setReorderingAllowed(false);
		
		//Colocando um tamanho para os colunas
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableClientes.getColumnModel().getColumn(0).setResizable(false);
		
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(478);
		tableClientes.getColumnModel().getColumn(1).setResizable(false);

		
		scrollTabela.setViewportView(tableClientes);
	}
	
	public void receberDados(String op) {
		FrmCliente frmCliente = new FrmCliente(op, op + "Cliente");
		
		//********Receber dados pela linha selecionada
		
		try {
			int linha = tableClientes.getSelectedRow();
		
			int id = (int) tableClientes.getValueAt(linha, 0); 
			
			dao = new ClienteDAO();
			
			Cliente cliente = new Cliente();
			
			cliente = dao.getCliente(id);
			
			frmCliente.setTxtID(cliente.getId());
			
			frmCliente.setTxtNome(cliente.getNome());
			
			frmCliente.setTxtData(cliente.getDtNascimento());
			
			frmCliente.setTxtPeso((cliente.getPeso()));
			
			frmCliente.setTxtAltura(cliente.getAltura());
			
			frmCliente.setCbSexo(cliente.getSexo());
			
			frmCliente.setCbNivel(cliente.getNivelAtividade());
			
			frmCliente.setVisible(true);
			
			} catch(Exception erro) {
			System.out.println(erro.getMessage());
			erro.printStackTrace();
			JOptionPane.showMessageDialog(null, "Por favor, "
					+ "selecione um contato", "Error Message", JOptionPane.ERROR_MESSAGE);
			
			
		}
	}
}
