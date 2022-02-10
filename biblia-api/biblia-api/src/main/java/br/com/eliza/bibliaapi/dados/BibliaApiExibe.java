package br.com.eliza.bibliaapi.dados;

public class BibliaApiExibe {
	private String nome;
	private String autor;
	private String grupo;
	
	public BibliaApiExibe(String nome, String autor, String grupo) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.grupo = grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	
}
