package br.com.eliza.bibliaapi.dto.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Livro {
	@JsonProperty("name")
	private String nome;
	@JsonProperty("author")
	private String autor;
	@JsonProperty("group")
	private String grupo;
	@JsonProperty("version")
	private String traducao;
	@JsonProperty("abbrev")
	private Abreviacao abreviacao;
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
	public String getTraducao() {
		return traducao;
	}
	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}
	public Abreviacao getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(Abreviacao abreviacao) {
		this.abreviacao = abreviacao;
	}
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", grupo=" + grupo + ", traducao=" + traducao
				+ ", abreviacao=" + abreviacao + "]";
	}
	
}
