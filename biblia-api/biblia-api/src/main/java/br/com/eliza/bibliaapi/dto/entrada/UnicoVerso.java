package br.com.eliza.bibliaapi.dto.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnicoVerso {
	@JsonProperty("book")
	private Livro livro;
	@JsonProperty("chapter")
	private int capitulo;
	@JsonProperty("number")
	private int numeroVersiculo;
	@JsonProperty("text")
	private String textoVersiculo;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}
	public int getNumeroVersiculo() {
		return numeroVersiculo;
	}
	public void setNumeroVersiculo(int numeroVersiculo) {
		this.numeroVersiculo = numeroVersiculo;
	}
	public String getTextoVersiculo() {
		return textoVersiculo;
	}
	public void setTextoVersiculo(String textoVersiculo) {
		this.textoVersiculo = textoVersiculo;
	}
	@Override
	public String toString() {
		return "UnicoVerso [livro=" + livro + ", capitulo=" + capitulo + ", numeroVersiculo=" + numeroVersiculo
				+ ", textoVersiculo=" + textoVersiculo + "]";
	}
	
}
