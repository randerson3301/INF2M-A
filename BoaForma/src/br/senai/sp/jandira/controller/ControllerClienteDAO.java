package br.senai.sp.jandira.controller;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

public class ControllerClienteDAO {

	// m�todo para setar o tipo de opera��o desejada

	public static void setOperacaoBanco(String oper, String id, ClienteDAO dao, Cliente cliente) {

		//dao.setCliente(cliente);

		if (oper.equals("Adicionar")) {
			System.out.println(oper);
			dao.gravar();
		} else if (oper.equals("Editar")) {
			cliente.setId(Integer.parseInt(id));
			dao.atualizar();
		} else if (oper.equals("Excluir")) {
			cliente.setId(Integer.parseInt(id));

			int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir " + "o cliente ?", "Confirma��o",
					JOptionPane.OK_OPTION, JOptionPane.CANCEL_OPTION);

			if (confirma == JOptionPane.OK_OPTION) {
				dao.excluir();

			} else if (confirma == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "O cliente n�o foi excluido", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// m�todo para identificar sexo
	public static void setSexo(String campo, boolean h) {
		if (h == true) {
			campo = "H";
		} else {
			campo = "M";
		}
	}
}
