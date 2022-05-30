package br.com.eliza.bibliaapi.dto.entrada;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParteDaBiblia {
	@JsonProperty("book")
	private Livro livro;
	@JsonProperty("chapter")
	private Capitulo capitulo;
	@JsonProperty("verses")
	private List<Versiculo> versiculos;
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	public List<Versiculo> getVersiculos() {
		return versiculos;
	}
	public void setVersiculos(List<Versiculo> versiculos) {
		this.versiculos = versiculos;
	}
	@Override
	public String toString() {
		return "ParteDaBiblia [livro=" + livro + ", capitulo=" + capitulo + ", versiculos=" + versiculos + "]";
	}
	
}
