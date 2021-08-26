package br.com.eliza.escola.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.eliza.escola.modelo.Serie;

public class SerieDao {
	private EntityManager  em;
	
	public SerieDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Serie serie) {
		this.em.persist(serie);
	}
	public void remover(Serie serie) {
		serie = em.merge(serie);
		this.em.remove(serie);
	}
	public Serie buscarPorId(Long id) {
		return em.find(Serie.class, id);
	}
	public List<Serie> buscarTodasSeries() {
		String jpql = "SELECT p FROM Serie p";
		return em.createQuery(jpql, Serie.class).getResultList();
	}
}
