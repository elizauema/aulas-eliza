package br.com.eliza.bibliaapi.dto.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Capitulo {
	@JsonProperty("number")
	private int numero;
	@JsonProperty("verses")
	private int qtdeVerso;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQtdeVerso() {
		return qtdeVerso;
	}
	public void setQtdeVerso(int qtdeVerso) {
		this.qtdeVerso = qtdeVerso;
	}
	@Override
	public String toString() {
		return "Capitulo [numero=" + numero + ", qtdeVerso=" + qtdeVerso + "]";
	}
	
}
