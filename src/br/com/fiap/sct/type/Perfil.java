package br.com.fiap.sct.type;

public enum Perfil {

	ADMINISTRADOR(0), PROFESSOR(1), ALUNO(2);

	private int codigo;

	private Perfil(int codigo) {
		this.setCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.name();
	}
}
