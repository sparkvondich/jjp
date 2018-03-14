package br.com.fiap.sct.dao;

import javax.persistence.TypedQuery;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.dao.util.JpaUtil;
import br.com.fiap.sct.entity.Escola;

public class EscolaDao extends GenericDao<Escola> {
	
	public EscolaDao(){
		super(Escola.class);
	}
	
	public Escola buscarEscola(String nome){
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();		
		
		TypedQuery<Escola> query = em.createQuery("select e from Escola e where e.nome = :nome", Escola.class);
		query.setParameter("nome", nome);
		
		return query.getSingleResult();
	}

}
