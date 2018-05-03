package br.senai.sp.jandira.model;

/*
 * Essa classe representa a camada de REGRA DE NEGÓCIOS, toda a lógica, métodos e atributos
 * devem permanecer e serem criados nessa E APENAS NESSA classe.
 */
public class Cliente {
	//Atributos do cliente
	private String nome;
	
	private int idade;
	
	private int peso;
	
	private int altura;
	
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
