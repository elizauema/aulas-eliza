package br.com.eliza.bibliaapi.dto.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versiculo {
	@JsonProperty("number")
	private int numero;
	@JsonProperty("text")
	private String texto;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Versiculo [numero=" + numero + ", texto=" + texto + "]";
	}
	
}
