package br.com.eliza.bibliaapi.dto.saida;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersiculoSaida {
	@JsonProperty("number")
	private int numero;
	@JsonProperty("text")
	private String texto;
	public VersiculoSaida(int numero, String texto) {
		super();
		this.numero = numero;
		this.texto = texto;
	}
	public VersiculoSaida() {
		
	}
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
