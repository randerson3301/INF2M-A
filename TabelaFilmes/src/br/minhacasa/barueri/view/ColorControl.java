package br.minhacasa.barueri.view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorControl extends DefaultTableCellRenderer{
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
			boolean hasFocus, int row, int col) {
		
		//Invocando um component
		Component comp = super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, col);
		
		if(row == SPECIAL.ROW)
		
	}
}
