package br.com.eliza.bibliaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Capitulo {
	@JsonProperty("number")
	private double numero;
	@JsonProperty("verses")
	private double qtdeVerso;
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
	@Override
	public String toString() {
		return "Capitulo [numero=" + numero + ", qtdeVerso=" + qtdeVerso + "]";
	}
	
}
