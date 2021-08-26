package br.com.eliza.escola.modelo;

import java.time.LocalDate;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
@Entity
@Table(name = "notas")
public class Nota {
	@EmbeddedId
	private NotaPK pk;
	
	private Float nota1Bimestre;
	private Float nota2Bimestre;
	private Float nota3Bimestre;
	private Float nota4Bimestre;
	private LocalDate dataCadastro = LocalDate.now();
	
	@MapsId("alunoPK") // maps alunoPK attribute of embedded id
	@ManyToOne
	private Aluno aluno;
	
	@MapsId("seriePK") // maps seriePK attribute of embedded id
	@ManyToOne
	private Serie serie;
	
	@MapsId("materiaPK") // maps materiaPK attribute of embedded id
	@ManyToOne
	private Materia materia;
	public Nota() {
	}
	
	public Nota(Float nota1Bimestre, Float nota2Bimestre, Float nota3Bimestre, Float nota4Bimestre,
			LocalDate dataCadastro) {
		super();
		this.nota1Bimestre = nota1Bimestre;
		this.nota2Bimestre = nota2Bimestre;
		this.nota3Bimestre = nota3Bimestre;
		this.nota4Bimestre = nota4Bimestre;
		this.dataCadastro = dataCadastro;
	}
	public Nota(Aluno aluno,  Serie serie, Materia materia, Float nota1Bimestre, 
			Float nota2Bimestre, Float nota3Bimestre, Float nota4Bimestre,
			LocalDate dataCadastro) {
		super();
		this.aluno = aluno;
		this.serie = serie;
		this.materia = materia;
		this.nota1Bimestre = nota1Bimestre;
		this.nota2Bimestre = nota2Bimestre;
		this.nota3Bimestre = nota3Bimestre;
		this.nota4Bimestre = nota4Bimestre;
		this.dataCadastro = dataCadastro;
		
	}
	
	public NotaPK getPk() {
		return pk;
	}
	public void setPk(NotaPK pk) {
		this.pk = pk;
	}
	public Float getNota1Bimestre() {
		return nota1Bimestre;
	}
	public void setNota1Bimestre(Float nota1Bimestre) {
		this.nota1Bimestre = nota1Bimestre;
	}
	public Float getNota2Bimestre() {
		return nota2Bimestre;
	}
	public void setNota2Bimestre(Float nota2Bimestre) {
		this.nota2Bimestre = nota2Bimestre;
	}
	public Float getNota3Bimestre() {
		return nota3Bimestre;
	}
	public void setNota3Bimestre(Float nota3Bimestre) {
		this.nota3Bimestre = nota3Bimestre;
	}
	public Float getNota4Bimestre() {
		return nota4Bimestre;
	}
	public void setNota4Bimestre(Float nota4Bimestre) {
		this.nota4Bimestre = nota4Bimestre;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
	