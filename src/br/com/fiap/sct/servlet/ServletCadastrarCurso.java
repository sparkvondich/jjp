package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.entity.Curso;
import br.com.fiap.sct.entity.Escola;

@WebServlet("/admin/cadastrarCurso")
public class ServletCadastrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("cadastrarCursos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			EscolaDao escolaDao = new EscolaDao();
			Escola escola = escolaDao.buscar(Integer.parseInt(request.getParameter("escolaSelecionada")));
			
			Curso curso = new Curso();
			curso.setEscola(escola);
			curso.setNome(request.getParameter("nome"));
			
			CursoDao cursoDao = new CursoDao();
			cursoDao.adicionar(curso);
			request.setAttribute("mensagem", "Curso: " + curso.getNome() + " incluído com sucesso");
			request.getRequestDispatcher("cadastrarCursos.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}
}
