package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
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
		btnAdicionar.setToolTipText("Adicionar Cliente");
		btnAdicionar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/add.png")));
			
		btnAdicionar.setBounds(10, 11, 74, 62);
		panelBotoes.add(btnAdicionar);

		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar Cliente");
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		btnEditar.setBounds(99, 11, 74, 62);
		panelBotoes.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Excluir Cliente");
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/delete.png")));
		btnExcluir.setBounds(187, 11, 74, 62);
		panelBotoes.add(btnExcluir);

		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair do programa");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/cancel.png")));
		btnSair.setBounds(433, 11, 74, 62);
		panelBotoes.add(btnSair);
		
		criarTabela();
		
		
	}
	
	public void criarTabela() {
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 97, 528, 317);
		panelPrincipal.add(scrollTabela);

		tableClientes = new JTable();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		
		
		
		scrollTabela.setViewportView(tableClientes);
	}
}
