package br.com.eliza.escola.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome_Materia;
	
	@ManyToMany(mappedBy="materias")
	List<Serie> series;
	
	@OneToMany(mappedBy="materia")
	private List<Nota>notas;
	
	public Materia() {
	}
	public Materia(String nome_Materia) {
		this.nome_Materia = nome_Materia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_Materia() {
		return nome_Materia;
	}
	public void setNome_Materia(String nome_Materia) {
		this.nome_Materia = nome_Materia;
	}
	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
}
