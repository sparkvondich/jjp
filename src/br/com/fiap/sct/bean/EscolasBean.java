package br.com.fiap.sct.bean;

import java.util.List;

import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.entity.Escola;

public class EscolasBean {

	public List<Escola> getConsultarEscolas() {
		EscolaDao escolaDao = new EscolaDao();
		return escolaDao.listar();
	}

}
