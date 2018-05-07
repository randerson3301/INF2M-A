package br.senai.sp.jandira.testes;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DataHoje {
	
	public static void main(String[] args) {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = new Date();
		
		System.out.println(df.format(date));
		
		String teste = df.format(date);
		
		System.out.println(teste);
	}
}
