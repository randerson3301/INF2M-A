package br.senai.sp.jandira.testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTesteData extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtData1;
	private JTextField txtDataHj;

	/**
	 * Create the frame.
	 */
	public FrmTesteData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblData1 = new JLabel("Insira sua data de nascimento:");
		lblData1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData1.setBounds(24, 64, 186, 14);
		panelPrincipal.add(lblData1);

		// formatando os campos

		MaskFormatter dtMask = null;

		try {
			dtMask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		txtData1 = new JFormattedTextField(dtMask);
		txtData1.setBounds(223, 63, 86, 20);
		panelPrincipal.add(txtData1);
		txtData1.setColumns(10);

		JLabel lblDataHj = new JLabel("Insira a data de hoje:");
		lblDataHj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataHj.setBounds(77, 100, 138, 14);
		panelPrincipal.add(lblDataHj);

		txtDataHj = new JFormattedTextField(dtMask);
		txtDataHj.setColumns(10);
		txtDataHj.setBounds(223, 99, 86, 20);
		panelPrincipal.add(txtDataHj);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TesteData.calcularData(txtData1.getText(), 
						txtDataHj.getText());
			}
		});
		btnCalcular.setBounds(154, 186, 89, 23);
		panelPrincipal.add(btnCalcular);
	}
	
	public static void main(String[] args) {
		FrmTesteData dta = new FrmTesteData();
		
		dta.setVisible(true);
	}
}
