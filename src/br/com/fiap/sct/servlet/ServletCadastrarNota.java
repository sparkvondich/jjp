package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.dao.NotasDao;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Disciplina;
import br.com.fiap.sct.entity.Nota;
import br.com.fiap.sct.entity.NotaPK;

@WebServlet("/admin/cadastrarNota")
public class ServletCadastrarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastrarNota() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			int codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));
			int codigoDisciplina = Integer.parseInt(request.getParameter("codigoDisciplina"));
			
			AlunoDao alunoDao = new AlunoDao();
			Nota nota = alunoDao.consultarBoletim(codigoAluno, codigoDisciplina);
			Aluno aluno = alunoDao.buscar(codigoAluno);

			DisciplinaDao disciplinaDao = new DisciplinaDao();
			Disciplina disciplina = disciplinaDao.buscar(codigoDisciplina);
			
			request.setAttribute("disciplina", disciplina);
			request.setAttribute("aluno", aluno);
			request.setAttribute("nota", nota);
			request.getRequestDispatcher("cadastrarNotas.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			int notaProjeto1 = Integer.parseInt(request.getParameter("projeto1"));
			int notaAtividadePratica = Integer.parseInt(request.getParameter("atividadePratica"));
			int notaProjeto2 = Integer.parseInt(request.getParameter("projeto2"));
			
			int codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));
			int codigoDisciplina = Integer.parseInt(request.getParameter("codigoDisciplina"));
			
			NotaPK notaPK = new NotaPK();
			notaPK.setAluno(codigoAluno);
			notaPK.setDisciplina(codigoDisciplina);
			
			Nota nota = new Nota();
			nota.setNotaPK(notaPK);
			nota.setProjeto1(notaProjeto1);
			nota.setAtividadePratica(notaAtividadePratica);
			nota.setProjeto2(notaProjeto2);
			
			
			new NotasDao().atualizar(nota);
			
//			request.setAttribute("nota", nota);
//			request.getRequestDispatcher("cadastrarNotas.jsp").forward(request, response);
			request.getRequestDispatcher("consultarBoletim").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
		
	}
}
