package br.com.fiap.sct.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.sct.type.Perfil;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -14032184034480956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "LOGIN", nullable = false, length = 45)
	private String login;

	@Column(name = "SENHA", nullable = false, length = 45)
	private String senha;

	@Column(name = "PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (login != null)
			builder.append("login=").append(login).append(", ");
		if (senha != null)
			builder.append("senha=").append(senha).append(", ");
		if (perfil != null)
			builder.append("perfil=").append(perfil);
		builder.append("]");
		return builder.toString();
	}
	
}
