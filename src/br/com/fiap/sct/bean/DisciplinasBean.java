package br.com.fiap.sct.bean;

import java.util.List;

import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.entity.Disciplina;

public class DisciplinasBean {
	
	public List<Disciplina> getConsultarDisciplinas(){
		return new DisciplinaDao().listar();
	}

}
