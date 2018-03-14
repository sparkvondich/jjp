package br.com.fiap.sct.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Curso;

/**
 * Servlet implementation class ServletExcluirAluno
 */
@WebServlet("/admin/excluirAluno")
public class ServletExcluirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletExcluirAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String codigo = (String) request.getParameter("codigo");
			AlunoDao alunoDao = new AlunoDao();
			Aluno aluno = new Aluno();
				if(codigo != null){
						aluno = alunoDao.buscaAlunoPoRA(Integer.parseInt(codigo));
						alunoDao.remover(aluno);
						request.setAttribute("mensagem", "Aluno: " + aluno.getNome() + " excluído com sucesso");
						request.getRequestDispatcher("cadastrarAlunos.jsp").forward(request, response);
				}
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("erros/exceptionPage.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
