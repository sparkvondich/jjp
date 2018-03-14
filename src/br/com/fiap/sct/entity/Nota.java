package br.com.fiap.sct.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NOTAS")
public class Nota implements Serializable {

	private static final long serialVersionUID = 4392047100016330244L;

	@EmbeddedId
	private NotaPK notaPK;
	
	@Column(name="PROJETO_1", nullable=false, length=2)
	private Integer projeto1;
	
	@Column(name="PROJETO_2", nullable=false, length=2)
	private Integer projeto2;
	
	@Column(name="ATIVIDADE_PRATICA", nullable=false, length=2)
	private Integer atividadePratica;

	public NotaPK getNotaPK() {
		return notaPK;
	}

	public void setNotaPK(NotaPK notaPK) {
		this.notaPK = notaPK;
	}

	public Integer getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(Integer projeto1) {
		this.projeto1 = projeto1;
	}

	public Integer getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(Integer projeto2) {
		this.projeto2 = projeto2;
	}

	public Integer getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(Integer atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

}
