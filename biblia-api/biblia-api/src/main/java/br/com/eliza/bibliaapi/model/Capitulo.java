package br.com.eliza.bibliaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Capitulo {
	@JsonProperty("number")
	private double numero;
	@JsonProperty("verses")
	private double qtdeVerso;
}
