package br.senai.sp.jandira.controller;

public class ControllerCliente {
	// Métodos para os cálculos de IMC

	public double calcularIMC(double peso, double altura) {

		altura = altura / 100;

		return peso / (altura * altura);
	}

	// método para validar a classificação do cliente
	public String validarClassificacao(double imc, String classificacao) {
		if (imc <= 16.9) {
			classificacao = "Muito Abaixo do peso";
			return classificacao;

		} else if (imc <= 18.4) {
			classificacao = " Abaixo do peso";
			return classificacao;

		} else if (imc <= 24.9) {
			classificacao = "Peso Normal";
			return classificacao;

		} else if (imc <= 29.9) {
			classificacao = "Acima do peso";
			return classificacao;

		} else if (imc <= 34.9) {
			classificacao = "Obesidade Grau I";
			return classificacao;

		} else if (imc <= 40) {
			classificacao = "Obesidade Grau II";
			return classificacao;

		} else if (imc > 40) {
			classificacao = "Obesidade Grau III";
			return classificacao;

		} else {
			return "";
		}
	}

	// método para validar os sintomas do usuário
	public String validarSintomas(double imc, String sintomas) {
		if (imc <= 16.9) {
			sintomas = "Queda de cabelo, infertilidade, ausência menstrual";
			return sintomas;

		} else if (imc <= 18.4) {
			sintomas = "Fadiga, stress, ansiedade";
			return sintomas;

		} else if (imc <= 24.9) {
			sintomas = "Menor risco de doenças";
			return sintomas;

		} else if (imc <= 29.9) {
			sintomas = "Fadiga, má circulação, varizes";
			return sintomas;

		} else if (imc <= 34.9) {
			sintomas = "Diabetes, angina, infarto, aterosclerose.";
			return sintomas;

		} else if (imc <= 40) {
			sintomas = "Apneia do sono, falta de ar.";
			return sintomas;

		} else if (imc > 40) {
			sintomas = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC ";
			return sintomas;

		} else {
			return "";

		}
	}

	// método para cálculo da taxa de nivel de acordo com o cliente
	public double calcularTaxaNivel(String nivelAtividade) {
		if (nivelAtividade.equals("Sedentário")) {
			return 1.20;
		}

		else if (nivelAtividade.equals("Levemente Ativo")) {
			return 1.37;
		
		} else if (nivelAtividade.equals("Moderadamente Ativo")) {
			return 1.55;
		
		} else if (nivelAtividade.equals("Bastante Ativo")) {
			return 1.70;

		} else if (nivelAtividade.equals("Muito Ativo")) {
			return 1.90;
		} else {
			return 0;
		}
	}

	// TMB
	public double calcularTMB(double peso, double altura, double idade, double taxaNivel, boolean homem) {

		System.out.println(idade);

		if (homem == true) {
			return (66 + (13.7 * peso) + (5 * altura) - (6.8 * idade)) * taxaNivel;

		} else if (homem == false) {
			return (665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade)) * taxaNivel;

		} else {
			return 0;
		}

	}

	// FCM
	public double calcularFCM(double idade, double peso, boolean homem) {

		peso = peso / 100;

		if (homem == true) {
			return ((210 - (0.5 * idade)) - peso) + 4;

		} else if (homem == false) {
			return ((210 - (0.5 * idade))) - peso;

		} else {
			return 0;
		}
	}
}
