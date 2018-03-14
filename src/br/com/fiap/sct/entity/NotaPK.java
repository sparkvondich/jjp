package br.com.fiap.sct.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotaPK implements Serializable {
	
	private static final long serialVersionUID = -1907774216456954487L;

	@Column(name="DISCIPLINA_ID", nullable=false)
	private Integer disciplina;
	
	@Column(name="ALUNO_ID", nullable=false)
	private Integer aluno;

	public Integer getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Integer disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + aluno;
		result = prime * result + disciplina;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NotaPK))
			return false;
		NotaPK other = (NotaPK) obj;
		if (aluno != other.aluno)
			return false;
		if (disciplina != other.disciplina)
			return false;
		return true;
	}

}
