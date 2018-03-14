package br.com.fiap.sct.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.dao.util.JpaUtil;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Disciplina;
import br.com.fiap.sct.entity.Nota;
import br.com.fiap.sct.entity.NotaPK;

public class AlunoDao extends GenericDao<Aluno> {

	public AlunoDao() {
		super(Aluno.class);
	}

	public List<Aluno> consultarAlunosPorProfessor(int codigoProfessor) {

		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Aluno> query = em.createQuery("select distinct a from Aluno a " + "inner join a.curso c " + "inner join c.disciplinas as d " + "where d.professor.id = :codigoProfessor",
					Aluno.class);
			query.setParameter("codigoProfessor", codigoProfessor);

			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Aluno consultarAlunoPeloUsuario(int codigoUsuario) {

		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Aluno> query = em.createQuery("select distinct a from Aluno a where a.usuario.id = :codigoUsuario",
					Aluno.class);

			query.setParameter("codigoUsuario", codigoUsuario);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Nota consultarBoletim(int codigoAluno, Integer codigoDisciplina) {
		
		NotaPK notaPK = new NotaPK();
		notaPK.setAluno(codigoAluno);
		notaPK.setDisciplina(codigoDisciplina);
		
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		return em.find(Nota.class, notaPK);
	}
		
	public List<Aluno> buscaAlunosPorCurso(int codigoCurso) {
		try {
		List<Aluno> lista = new ArrayList<Aluno>();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Aluno> query = em.createQuery(
				"select a from Aluno a "
				+ "inner join a.curso ac "
				+ "where ac.id = :codigoCurso ", Aluno.class);
		query.setParameter("codigoCurso", codigoCurso);
		 lista = (List<Aluno>) query.getResultList();
		 return lista;
		} catch (NoResultException e) {
			return null;
		}
		}
	
	public Aluno buscaAlunoPoRA(int ra){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Aluno> query = em.createQuery("select distinct a from Aluno a where a.ra = :ra", Aluno.class);
			query.setParameter("ra", ra);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
