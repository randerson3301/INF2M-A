package br.senai.sp.jandira.CalculadoraAcademia;

/*
 * Essa classe representa a camada de REGRA DE NEGÓCIOS, toda a lógica, métodos e atributos
 * devem permanecer e serem criados nessa E APENAS NESSA classe.
 */
public class ClienteAcademia {
	//Atributos do cliente
	private String nome;
	
	private double idade;
	
	private double peso;
	
	private double altura;
	
	private char sexo;
	
	private String nivelAtividade;
	
	private double taxaNivel;
	
	//Atributos dos cálculos
	private double imc;
	
	private double fcm;

	private double tmb;
	
	
	//Métodos 
	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getFcm() {
		return fcm;
	}

	public void setFcm(double fcm) {
		this.fcm = fcm;
	}

	public double getTmb() {
		return tmb;
	}

	public void setTmb(double tmb) {
		this.tmb = tmb;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}

	public String getNivelAtividade() {
		return nivelAtividade;
	}

	public void setNivelAtividade(String nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}

	public double getTaxaNivel() {
		return taxaNivel;
	}

	public void setTaxaNivel(double taxaNivel) {
		this.taxaNivel = taxaNivel;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	//Métodos para os cálculos de IMC
	
	public double calcularIMC(double peso, double altura ) {
		
		altura = altura /100;
		
		return peso / (altura * altura);
	}
	
	//método para validar a classificação do cliente
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
	
	//método para validar os sintomas do usuário
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
	
	
	//método para cálculo da taxa de nivel de acordo com o cliente
	public double calcularTaxaNivel(String nivelAtividade) {
		if (nivelAtividade.equals("Sedentário") ) {
			return 1.20;
		}

		else if (nivelAtividade.equals("Levemente Ativo")) {
			return 1.37;
		}
		 else if (nivelAtividade.equals("Moderadamente Ativo")) {
			 return  1.55;
		}
		 else if (nivelAtividade.equals("Bastante Ativo")) {
			 return  1.70;
		
		 } else if (nivelAtividade.equals("Muito Ativo")) {
			 return  1.90;
		} else {
			return 0;
		}
	}
	
	//TMB
	public double calcularTMB(double peso, double altura, double idade, 
			double taxaNivel, boolean homem) {
		
		if (homem == true) {
			return (66 + (13.7 * peso) + (5 * altura) - (6.8 * idade)) * taxaNivel;
		
		} else if (homem == false) {
			return (665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade)) * taxaNivel;
		
		} else {
			return 0;
		}
	
	}
	
	//FCM
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
