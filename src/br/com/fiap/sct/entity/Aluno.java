package br.com.fiap.sct.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNOS")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 422519831384293718L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false) 
	private Integer id;
	
	@Column(name = "RA", nullable=false, length=10)
	private Integer ra;

	@Column(name="NOME", nullable=false, length=45)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Curso curso;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="NOTA_ID")
	private Set<Nota> notas  = new HashSet<>();

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> nota) {
		this.notas = nota;
	}
	
	public void addNota(Nota nota){
		this.notas.add(nota);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", ra=" + ra + ", nome=" + nome + ", usuario=" + usuario + "]";
	}
	
}
