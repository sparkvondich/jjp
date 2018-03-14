package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.entity.Curso;
import br.com.fiap.sct.entity.Disciplina;
import br.com.fiap.sct.entity.Professor;

@WebServlet("/admin/cadastrarDisciplina")
public class ServletCadastrarDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarDisciplina() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("cadastrarCursos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			CursoDao cursoDao = new CursoDao();
			Curso cursoSelecionado = cursoDao.buscar(Integer.parseInt(request.getParameter("cursoSelecionado")));
			
			ProfessorDao professorDao = new ProfessorDao();
			Professor professorSelecionado = professorDao.buscar(Integer.parseInt(request.getParameter("professorSelecionado")));
			
			DisciplinaDao disciplinaDao = new DisciplinaDao();
			Disciplina disciplina = new Disciplina();
			disciplina.setNome(request.getParameter("nome"));
			disciplina.setCurso(cursoSelecionado);
			disciplina.setProfessor(professorSelecionado);
			disciplinaDao.adicionar(disciplina);
			request.setAttribute("mensagem", "Disciplina incluída com sucesso");
			request.getRequestDispatcher("cadastrarDisciplinas.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}
}
