package br.com.fiap.sct.teste;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.dao.NotasDao;
import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.dao.UsuarioDao;
import br.com.fiap.sct.entity.Usuario;
import br.com.fiap.sct.type.Perfil;

public class Main {

	public static void main(String[] args) {

		EscolaDao escolaDao = new EscolaDao();
		CursoDao cursoDao = new CursoDao();
		ProfessorDao professorDao = new ProfessorDao();
		AlunoDao alunoDao = new AlunoDao();
		DisciplinaDao disciplinaDao = new DisciplinaDao();
		NotasDao notasDao = new NotasDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		
		Usuario usuarioAluno = new Usuario();
		usuarioAluno.setLogin("user");
		usuarioAluno.setSenha("123");
		usuarioAluno.setPerfil(Perfil.ADMINISTRADOR);
		usuarioDao.adicionar(usuarioAluno);
		System.out.println(usuarioAluno);

		
	}
}
