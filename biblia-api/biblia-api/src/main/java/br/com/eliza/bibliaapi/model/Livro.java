package br.com.eliza.bibliaapi.model;

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
	
}
