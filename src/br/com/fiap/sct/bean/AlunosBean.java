package br.com.fiap.sct.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dto.NotaDisciplina;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Disciplina;
import br.com.fiap.sct.entity.Nota;

public class AlunosBean {
	
	private int codigoProfessor;
	private int codigoAluno;
	
	public List<Aluno> getConsultarAlunos(){
		return new AlunoDao().listar();
	}
	
	public List<Aluno> getConsultarAlunosPorProfessor(){
		return new AlunoDao().consultarAlunosPorProfessor(codigoProfessor);
	}
	
	public List<NotaDisciplina> getConsultarBoletim(){
		
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.buscar(codigoAluno);
		
		List<NotaDisciplina> boletim = new ArrayList<>();
		Set<Disciplina> disciplinas = aluno.getCurso().getDisciplinas();
		
		for (Disciplina disciplina : disciplinas) {
			NotaDisciplina notaDisciplina = new NotaDisciplina();
			Nota nota = alunoDao.consultarBoletim(codigoAluno, disciplina.getId());
			notaDisciplina.setCodigoAluno(codigoAluno);
			notaDisciplina.setCodigoDisciplina(disciplina.getId());
			notaDisciplina.setDescricaoDisciplina(disciplina.getNome());
			notaDisciplina.setNota(nota);
			boletim.add(notaDisciplina);
		}
		
		return boletim;
	}

	public int getCodigoProfessor() {
		return codigoProfessor;
	}

	public void setCodigoProfessor(int codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	

}
