package br.senai.sp.jandira.testes;

import javax.swing.JOptionPane;

public class TesteData {
	public static void calcularData(String dtNasc, String dtHj) {

		int y1 = Integer.parseInt(dtNasc.substring(6, 10));

		int y2 = Integer.parseInt(dtHj.substring(6, 10));

		// System.out.println(dtNasc.substring(0, 5));
		int r = 0;
		
		if (dtNasc.substring(0, 5).equals("29/02") || 
				dtHj.substring(0, 5).equals("29/02")) {
			verificarAnoBissexto(y1, y2);
			
		} 
		
		r = y2 - y1;
		

		int m1 = Integer.parseInt(dtNasc.substring(3, 5));

		int m2 = Integer.parseInt(dtHj.substring(3, 5));

		if (m2 > m1) {
			JOptionPane.showMessageDialog(null, "Você possui: " + r + " anos");
		}

		else if (m2 == m1) {
			int d1 = Integer.parseInt(dtNasc.substring(0, 2));

			int d2 = Integer.parseInt(dtHj.substring(0, 2));

			if (d1 > d2) {
				JOptionPane.showMessageDialog(null, "Você possui: " + (r - 1) + " anos");
			} else {
				JOptionPane.showMessageDialog(null, "Você possui: " + r + " anos");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Você possui: " + (r - 1) + " anos");
		}

	}

	public static boolean verificarAnoBissexto(int ano, int ano2) {

		int result = ano % 4;

		if (result == 0) {
			int divPor100 = ano % 100;

			if (divPor100 == 0) {

				JOptionPane.showMessageDialog(null, ano 
						+ " não é bissexto", "Error", 
						JOptionPane.ERROR_MESSAGE);
				
				return false;
				
			} 
		} else {
			int result2 = ano % 4;

			if (result2 != 0) {

				int divPor400 = ano % 400;

				if (divPor400 != 0) {
					JOptionPane.showMessageDialog(null, ano + 
							" não é bissexto", "Error",
							JOptionPane.ERROR_MESSAGE);
					return false;
					
				}
			}
		}
		
		return true;
	}
}
