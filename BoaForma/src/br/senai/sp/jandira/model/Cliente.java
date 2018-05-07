package br.senai.sp.jandira.model;

/*
 * Essa classe representa a modelagem de um objeto, ou seja quais atributos
 * deve conter.
 */
public class Cliente {
	// Atributos do cliente
	private int id;

	private String nome;

	private String dtNascimento;

	private int peso;

	private int altura;

	private String sexo;

	private String nivelAtividade;

	private double taxaNivel;

	// Atributos dos cálculos
	private double imc;

	private double fcm;

	private double tmb;

	// *************Métodos getters e setters****************
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String data) {
		this.dtNascimento = data;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNivelAtividade() {
		return nivelAtividade;
	}

	public void setNivelAtividade(String nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}

	// atributos para os cálculos
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

	public double getTaxaNivel() {
		return taxaNivel;
	}

	public void setTaxaNivel(double taxaNivel) {
		this.taxaNivel = taxaNivel;
	}
}
