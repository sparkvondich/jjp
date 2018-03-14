package br.com.fiap.sct.dto;

import br.com.fiap.sct.entity.Nota;
import br.com.fiap.sct.type.Status;

public class NotaDisciplina {
	
	private Integer codigoAluno;
	private Integer codigoDisciplina;
	private String descricaoDisciplina;
	private Nota nota;
	private double media;
	private Status status;
	
	public String getDescricaoDisciplina() {
		return descricaoDisciplina;
	}
	public void setDescricaoDisciplina(String descricaoDisciplina) {
		this.descricaoDisciplina = descricaoDisciplina;
	}
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	public Status getStatus(){
		if(isAprovado()) return Status.APROVADO;
		else return Status.REPROVADO;
			
	}
	
	public boolean isAprovado() {
		
		if(this.getMedia() >= 7.0){
			return true;
		} else {
			return false;
		}
		
	}
	
	public double getMedia(){
		if(this.hasAllNotes()){
			double notaFinalProjeto1 = ((float)nota.getProjeto1().intValue()  * 0.3);
			double notaFinalAtividadePratica = ((float)nota.getAtividadePratica().intValue()  * 0.3);
			double notaFinalProjeto2 = ((float) nota.getProjeto2().intValue()  * 0.4);
			
			return notaFinalProjeto1 + notaFinalAtividadePratica + notaFinalProjeto2;
			
		}
		
		return 0.0;
	}
	
	public boolean hasAllNotes(){
		if(nota != null){
			if(nota.getProjeto1() != 0 && nota.getAtividadePratica() != 0 && nota.getProjeto2() != 0){
				return true;
			}
		}
		
		return false;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public Integer getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(Integer codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public Integer getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(Integer codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

}
