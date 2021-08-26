package br.com.eliza.escola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.eliza.escola.modelo.Aluno;
import br.com.eliza.escola.modelo.Nota;

public class NotaDao {
private EntityManager em;
	
	public NotaDao(EntityManager em) {
		this.em = em;
	}
	public void cadastrar(Nota nota) {
		this.em.persist(nota);
	}
	public void atualizar(Nota nota) {
		this.em.merge(nota);
	}
	public void remover(Nota nota) {
		nota = em.merge(nota);
		this.em.remove(nota);
	}
	public Nota buscarPorId(Long id) {
		return em.find(Nota.class, id);
	}
	public List<Nota> buscarPorAluno(Long id_aluno) {
		String jpql = "SELECT p FROM Nota p where p.aluno_id = :id_aluno";
		return em.createQuery(jpql, Nota.class)
				.setParameter("id_aluno", id_aluno)
				.getResultList();
	}
	public List<Nota> buscarPorSerie(Long id_serie) {
		String jpql = "SELECT p FROM Nota p where serie = id_serie";
		return em.createQuery(jpql, Nota.class).getResultList();
	}
	
//	public Nota buscarPorIdComposto(long idAluno, long idSerie, long idMateria) {
//		String jpql = "SELECT n FROM Nota n WHERE n.aluno.id = :idAluno AND n.serie.id = :idSerie AND n.materia.id = :idMateria";
//		return em.createQuery(jpql, Nota.class)
//				.setParameter("idAluno", idAluno)
//				.setParameter("idSerie", idSerie)
//				.setParameter("idMateria", idMateria)
//				.getSingleResult();
//	}
//	
//	public Nota buscarPorIdCompostoNativeQuery(long idAluno, long idSerie, long idMateria) {
//		String sql = "SELECT * FROM notas WHERE aluno_id = :idAluno AND serie_id = :idSerie AND materia_id = :idMateria";
//		Query query = em.createNativeQuery(sql)
//			.setParameter("idAluno", idAluno)
//			.setParameter("idSerie", idSerie)
//			.setParameter("idMateria", idMateria);
//		
//		@SuppressWarnings("unchecked")
//		List<Object[]> resultList = query.getResultList();
//		
//		if(resultList.size() > 0) {
//			Object[] array = resultList.get(0);
//			Nota nota = new Nota((float)array[0], (float)array[1], (float)array[2], (float)array[3]);
//			return nota;
//		}else {
//			throw new RuntimeException("Nota não encontrada");
//		}
//	}
//
}
