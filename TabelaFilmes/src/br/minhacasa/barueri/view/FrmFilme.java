package br.minhacasa.barueri.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import br.minhacasa.barueri.dao.FilmeDAO;
import br.minhacasa.barueri.model.Filme;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmFilme extends JFrame {

	
	private JPanel panelPrincipal;
	private JTextField txtID;
	private JTextField txtTitulo;
	private JTextField txtAno;
	private JTextField txtDiretor;
	private JTextField txtTempo;
	private JTextField txtGenero;
	private JComboBox cbVisto;
	private JTextArea txtSinopse;
	
	Filme filme = new Filme();
	
	

	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));
	}



	public void setTxtTitulo(String nome) {
		this.txtTitulo.setText(nome);
	}



	public void setTxtAno(String ano) {
		this.txtAno.setText(ano);
	}



	public void setTxtDiretor(String diretor) {
		this.txtDiretor.setText(diretor);
	}



	public void setTxtTempo(String tempo) {
		this.txtTempo.setText(tempo);
	}



	public void setTxtGenero(String genero) {
		this.txtGenero.setText(genero);
	}



	public void setCbVisto(String opcao) {
		if(opcao.equals("Sim")) {
			cbVisto.setSelectedIndex(0);
			filme.setVisto(String.valueOf(cbVisto.getSelectedItem()));
			
		} else {
			cbVisto.setSelectedIndex(1);
			filme.setVisto(String.valueOf(cbVisto.getSelectedItem()));
		}
	}



	public void setTxtSinopse(String sinopse) {
		this.txtSinopse.setText(sinopse);
	}



	/**
	 * Create the frame.
	 */
	public FrmFilme(String operacao) {
		setBounds(100, 100, 422, 484);
		panelPrincipal = new JPanel();
		panelPrincipal.setForeground(Color.LIGHT_GRAY);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setForeground(Color.BLUE);
		panelTitulo.setBounds(0, 0, 406, 45);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblFilme = new JLabel("Filme");
		lblFilme.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblFilme.setBounds(10, 11, 80, 23);
		panelTitulo.add(lblFilme);
		
		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setForeground(Color.RED);
		lblOperacao.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblOperacao.setBounds(283, 11, 94, 23);
		panelTitulo.add(lblOperacao);
		
		JPanel panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDados.setBounds(10, 56, 386, 331);
		panelPrincipal.add(panelDados);
		panelDados.setLayout(null);
		
		JLabel lblID = new JLabel("ID: ");
		lblID.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblID.setBounds(10, 22, 28, 14);
		panelDados.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(46, 19, 57, 23);
		panelDados.add(txtID);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 55, 71, 14);
		panelDados.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(79, 53, 297, 24);
		panelDados.add(txtTitulo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblAno.setBounds(10, 98, 46, 14);
		panelDados.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(61, 97, 57, 23);
		panelDados.add(txtAno);
		
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDiretor.setBounds(139, 100, 71, 14);
		panelDados.add(lblDiretor);
		
		txtDiretor = new JTextField();
		txtDiretor.setColumns(10);
		txtDiretor.setBounds(214, 98, 162, 23);
		panelDados.add(txtDiretor);
		
		JLabel lblTempo = new JLabel("Tempo:");
		lblTempo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTempo.setBounds(10, 141, 71, 22);
		panelDados.add(lblTempo);
		
		txtTempo = new JTextField();
		txtTempo.setColumns(10);
		txtTempo.setBounds(85, 144, 86, 23);
		panelDados.add(txtTempo);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblGenero.setBounds(188, 141, 71, 22);
		panelDados.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(266, 144, 110, 23);
		panelDados.add(txtGenero);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSinopse.setBounds(10, 188, 86, 22);
		panelDados.add(lblSinopse);
		
		JScrollPane scrollSinopse = new JScrollPane();
		scrollSinopse.setBounds(10, 221, 366, 99);
		panelDados.add(scrollSinopse);
		
		txtSinopse = new JTextArea();
		scrollSinopse.setViewportView(txtSinopse);
		txtSinopse.setLineWrap(true);
		
		JLabel lblVisto = new JLabel("J\u00E1 Vi?");
		lblVisto.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblVisto.setBounds(229, 188, 86, 22);
		panelDados.add(lblVisto);
		
		cbVisto = new JComboBox();
		cbVisto.setModel(new DefaultComboBoxModel(new String[] {"Sim", "N\u00E3o"}));
		cbVisto.setBounds(297, 192, 79, 20);
		panelDados.add(cbVisto);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FilmeDAO dao = new FilmeDAO();
					
					Filme filme = new Filme();
					
					filme.setTitulo(txtTitulo.getText());
					filme.setDtLancamento(txtAno.getText());
					filme.setDiretor(txtDiretor.getText());
					filme.setGenero(txtGenero.getText());
					filme.setVisto(cbVisto.getSelectedItem().toString());
					filme.setSinopse(txtSinopse.getText());
					filme.setDuracao(txtTempo.getText());
					
					dao.setFilme(filme);
					
					if(lblOperacao.getText().equals("Adicionar")) {
						dao.gravar();
						limparDados();
						
					} else if(lblOperacao.getText().equals("Editar")) {
						filme.setId(Integer.parseInt(txtID.getText()));
						
						dao.atualizar();
					
					} else if(lblOperacao.getText().equals("Excluir")) {
						filme.setId(Integer.parseInt(txtID.getText()));
						
						dao.deletar();
					}
				
				} catch(Exception erro) {
					System.out.println(erro.getMessage());
					
					
					JOptionPane.showMessageDialog(null, 
							"Não foi possível realizar a operação",
							"Alerta de Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(FrmFilme.class.getResource("/br/minhacasa/barueri/imagens/save.png")));
		btnSalvar.setBounds(10, 392, 63, 47);
		panelPrincipal.add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmFilme.class.getResource("/br/minhacasa/barueri/imagens/cancel.png")));
		btnCancelar.setBounds(333, 392, 63, 47);
		panelPrincipal.add(btnCancelar);
	}
	
	private void limparDados() {
		txtID.setText("");
		txtTitulo.setText("");
		txtDiretor.setText("");
		txtAno.setText("");
		txtGenero.setText("");
		txtSinopse.setText("");
		txtTempo.setText("");
		
		txtTitulo.grabFocus();
		
	}
}
