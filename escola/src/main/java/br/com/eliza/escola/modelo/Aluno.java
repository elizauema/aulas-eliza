package br.com.eliza.escola.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascto;
    private String cpf;
	private String serieAtual;
	
	@ManyToMany
    @JoinTable(name = "aluno_serie",joinColumns= {@JoinColumn(name="aluno_id")},inverseJoinColumns= {@JoinColumn(name="serie_id")})
	private List<Serie> series;
	
	@OneToMany(mappedBy = "aluno")
	private List<Nota> notas;
	
	public Aluno() {
	}
	
	public Aluno(String nome, String serieAtual) {
		this.nome = nome;
		this.serieAtual = serieAtual;
	}
	public Aluno(String nome, String sobrenome, LocalDate dataNascto, String cpf, String serieAtual) {
		this.nome = nome;
		this.sobrenome =  sobrenome;
		this.dataNascto = dataNascto;
	    this.cpf = cpf;
		this.serieAtual = serieAtual;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascto() {
		return dataNascto;
	}

	public void setDataNascto(LocalDate dataNascto) {
		this.dataNascto = dataNascto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSerieAtual() {
		return serieAtual;
	}

	public void setSerieAtual(String serieAtual) {
		this.serieAtual = serieAtual;
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

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", serieAtual=" + serieAtual + "]";
	}

}
