package br.senai.sp.jandira.controller;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

public class ControllerClienteDAO {
	
	//método para setar o tipo de operação desejada
	
	public static void setOperacaoBanco(String op, String id) {
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		if(op.equals("Adicionar")) {
			dao.gravar();
		} else if(op.equals("Editar")) {
			cliente.setId(Integer.parseInt(id));
			dao.atualizar();
		} else if(op.equals("Excluir")) {
			cliente.setId(Integer.parseInt(id));
			
			int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir "
					+ "o cliente ?", "Confirmação", JOptionPane.OK_OPTION, 
					JOptionPane.CANCEL_OPTION);
			
			if(confirma == JOptionPane.OK_OPTION) {
				dao.excluir();
			
			} else if(confirma == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, 
						"O cliente não foi excluido", 
						"Info", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//método para identificar sexo
	public static void setSexo(String campo, boolean h) {
		if(h) {
			campo = "H";
		} else {
			campo = "M";
		}
	}
}
