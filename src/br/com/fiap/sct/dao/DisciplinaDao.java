package br.com.fiap.sct.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.dao.util.JpaUtil;
import br.com.fiap.sct.entity.Disciplina;

public class DisciplinaDao extends GenericDao<Disciplina> {

	public DisciplinaDao() {
		super(Disciplina.class);
	}
	
	public List<Disciplina> buscarDisciplinasPorCurso(int codigoCurso){
		List<Disciplina> lista = new ArrayList<Disciplina>();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Disciplina> query = em.createQuery(
				"select d from Disciplina d "
				+ "inner join d.curso dc "
				+ "where dc.id = :codigoCurso ", Disciplina.class);
		query.setParameter("codigoCurso", codigoCurso);
		 lista = (List<Disciplina>) query.getResultList();
		 return lista;
	}
	

}
