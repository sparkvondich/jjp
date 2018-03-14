package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.dao.UsuarioDao;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Curso;
import br.com.fiap.sct.entity.Usuario;
import br.com.fiap.sct.type.Perfil;

@WebServlet("/admin/cadastrarAluno")
public class ServletCadastrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("cadastrarAlunos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			CursoDao cursoDao = new CursoDao();
			Curso cursoSelecionado = cursoDao.buscar(Integer.parseInt(request.getParameter("cursoSelecionado")));
			
			Aluno aluno = new Aluno();
			aluno.setCurso(cursoSelecionado);
			aluno.setNome(request.getParameter("nome"));
			aluno.setRa(Integer.parseInt(request.getParameter("ra")));
			
			Usuario usuario = new Usuario();
			usuario.setPerfil(Perfil.ALUNO);
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			aluno.setUsuario(usuario);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			AlunoDao alunoDao = new AlunoDao();
			usuarioDao.adicionar(usuario);
			alunoDao.adicionar(aluno);
			
			request.setAttribute("mensagem", "Usuário " + usuario.getId() + " incluído com sucesso");
			
			request.getRequestDispatcher("cadastrarAlunos.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}
}
