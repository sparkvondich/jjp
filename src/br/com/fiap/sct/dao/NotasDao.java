package br.com.fiap.sct.dao;

import br.com.fiap.sct.dao.util.GenericDao;
import br.com.fiap.sct.entity.Nota;

public class NotasDao extends GenericDao<Nota>{

	public NotasDao() {
		super(Nota.class);
	}

}
