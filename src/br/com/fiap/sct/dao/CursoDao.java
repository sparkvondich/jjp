package br.com.fiap.sct.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.dao.util.JpaUtil;
import br.com.fiap.sct.entity.Curso;

public class CursoDao extends GenericDao<Curso> {

	public CursoDao() {
		super(Curso.class);
	}
	
	public List<Curso> buscarCursoPorEscola(int codigoEscola){
		try {
			List<Curso> lista = new ArrayList<Curso>();
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Curso> query = em.createQuery(
					"select c from Curso c "
					+ "inner join c.escola ce "
					+ "where ce.id = :codigoEscola ", Curso.class);
			query.setParameter("codigoEscola", codigoEscola);
			 lista = (List<Curso>) query.getResultList();
			 return lista;
		} catch (NoResultException e) {
			return null;
		}	
	}

}
