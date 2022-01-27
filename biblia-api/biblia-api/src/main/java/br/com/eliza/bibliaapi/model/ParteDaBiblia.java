package br.com.eliza.bibliaapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParteDaBiblia {
	@JsonProperty("book")
	private Livro livro;
	@JsonProperty("chapter")
	private Capitulo capitulo;
	@JsonProperty("verses")
	private List<Versiculo> versiculos;
}
