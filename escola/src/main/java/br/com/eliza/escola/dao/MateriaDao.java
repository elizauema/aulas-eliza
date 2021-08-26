package br.com.eliza.escola.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.eliza.escola.modelo.Materia;

public class MateriaDao {
	private EntityManager em;
	
	public MateriaDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Materia materia) {
		this.em.persist(materia);
	}
	public void atualizar(Materia materia) {
		materia = em.merge(materia);
	}
	public void remover(Materia materia) {
		materia = em.merge(materia);
		this.em.remove(materia);
	}
	public Materia buscarPorId(Long id) {
		return em.find(Materia.class, id);
	}
	public List<Materia> buscarTodasMaterias() {
		String jpql = "SELECT p FROM Materia p";
		return em.createQuery(jpql, Materia.class).getResultList();
	}
}
