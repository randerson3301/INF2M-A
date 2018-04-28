package br.minhacasa.barueri.model;

public class Filme {

	// -----Atributos do Objeto Filme--------
	private int id;
	private String titulo;
	private String dtLancamento;
	private String diretor;
	private String duracao;
	private String genero;
	private String sinopse;
	private String visto;

	// -----Comportamento da Classe------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(String dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getVisto() {
		return visto;
	}

	public void setVisto(String visto) {
		this.visto = visto;
	}

}
