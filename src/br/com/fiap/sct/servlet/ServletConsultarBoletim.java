package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.entity.Aluno;

@WebServlet("/admin/consultarBoletim")
public class ServletConsultarBoletim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConsultarBoletim() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			int codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));

			AlunoDao alunoDao = new AlunoDao();
			Aluno aluno = alunoDao.buscar(codigoAluno);

			request.setAttribute("aluno", aluno);
			request.getRequestDispatcher("consultarBoletim.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			int codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));

			AlunoDao alunoDao = new AlunoDao();
			Aluno aluno = alunoDao.buscar(codigoAluno);

			request.setAttribute("aluno", aluno);
			request.getRequestDispatcher("consultarBoletim.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}
}
