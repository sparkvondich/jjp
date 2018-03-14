package br.com.fiap.sct.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.dao.util.JpaUtil;
import br.com.fiap.sct.entity.Usuario;
import br.com.fiap.sct.type.Perfil;

public class UsuarioDao extends GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario buscarUsuario(String nome, String senha, Perfil perfil) {
		Usuario usuario = new Usuario();
		usuario.setLogin(nome);
		usuario.setPerfil(perfil);
		usuario.setSenha(senha);
		return usuario;
//		try {
//
//			em = JpaUtil.getEntityManager();
//			em.getTransaction().begin();
//
//			TypedQuery<Usuario> query = em.createQuery("select e from Usuario e where e.login = :login and e.senha = :senha and e.perfil = :perfil", Usuario.class);
//
//			query.setParameter("login", nome);
//			query.setParameter("senha", senha);
//			query.setParameter("perfil", perfil);
//
//			return query.getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
	}

}
