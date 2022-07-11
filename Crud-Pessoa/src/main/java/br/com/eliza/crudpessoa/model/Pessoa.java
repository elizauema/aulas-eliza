package br.com.eliza.crudpessoa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private String dtnascto;
	private String sexo;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
		
	
	public Pessoa(){
	}
	
	public Pessoa(Long id, String cpf, String nome, String dtnascto, String sexo, Endereco endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dtnascto = dtnascto;
		this.sexo = sexo;
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtnascto() {
		return dtnascto;
	}
	public void setDtnascto(String dtnascto) {
		this.dtnascto = dtnascto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", dtnascto=" + dtnascto + ", sexo=" + sexo + "]";
	}
	
}
