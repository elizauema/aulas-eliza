package br.com.eliza.escola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.eliza.escola.modelo.Aluno;

public class AlunoDao {
	private EntityManager em;
	
	public AlunoDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Aluno aluno) {
		this.em.persist(aluno);
	}
	public void atualizar(Aluno aluno) {
		this.em.merge(aluno);
	}
	public void remover(Aluno aluno) {
		aluno = em.merge(aluno);
		this.em.remove(aluno);
	}
	public Aluno buscarPorId(Long id) {
		return em.find(Aluno.class, id);
	}
	public List<Aluno> buscarTodos() {
		String jpql = "SELECT p FROM Aluno p";
		return em.createQuery(jpql, Aluno.class).getResultList();
	}
}
