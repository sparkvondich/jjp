package br.com.fiap.sct.bean;

import java.util.List;

import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.entity.Professor;

public class ProfessoresBean {
	
	public List<Professor> getConsultarProfessores(){
		return new ProfessorDao().listar();
	}

}
