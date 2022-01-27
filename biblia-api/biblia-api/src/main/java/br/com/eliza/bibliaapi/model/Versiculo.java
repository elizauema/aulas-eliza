package br.com.eliza.bibliaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versiculo {
	@JsonProperty("number")
	private int numero;
	@JsonProperty("text")
	private String texto;
}
