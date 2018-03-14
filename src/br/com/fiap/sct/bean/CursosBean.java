package br.com.fiap.sct.bean;

import java.util.List;

import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.entity.Curso;

public class CursosBean {
	
	public List<Curso> getConsultarCursos(){
		return new CursoDao().listar();
	}

}
