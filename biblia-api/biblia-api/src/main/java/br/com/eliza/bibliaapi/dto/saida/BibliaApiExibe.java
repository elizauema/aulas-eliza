package br.com.eliza.bibliaapi.dto.saida;

import java.util.List;

public class BibliaApiExibe {
	private String nome;
	private String autor;
	private String grupo;
	private String traducao;
	private AbreviacaoSaida abreviacao;
	private double numero;
	private double qtdeVerso;
	private List<VersiculoSaida> versiculos;
	
	public BibliaApiExibe(String nome, String autor, String grupo, String traducao, AbreviacaoSaida abreviacao, double numero, double qtdeVerso, List<VersiculoSaida> versiculos) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.grupo = grupo;
		this.traducao = traducao;
		this.abreviacao = abreviacao;
		this.numero = numero;
		this.qtdeVerso = qtdeVerso;
		this.versiculos = versiculos;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	public AbreviacaoSaida getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(AbreviacaoSaida abreviacao) {
		this.abreviacao = abreviacao;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public double getQtdeVerso() {
		return qtdeVerso;
	}

	public void setQtdeVerso(double qtdeVerso) {
		this.qtdeVerso = qtdeVerso;
	}

	public List<VersiculoSaida> getVersiculos() {
		return versiculos;
	}

	public void setVersiculos(List<VersiculoSaida> versiculos) {
		this.versiculos = versiculos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	
}
