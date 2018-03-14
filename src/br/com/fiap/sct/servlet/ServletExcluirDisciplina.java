package br.com.fiap.sct.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.entity.Disciplina;

/**
 * Servlet implementation class ServeltExcluirDisciplina
 */
@WebServlet("/admin/excluirDisciplina")
public class ServletExcluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletExcluirDisciplina() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String codigo = (String) request.getParameter("codigo");
			ProfessorDao dao = new ProfessorDao();
			DisciplinaDao disciplinaDao = new DisciplinaDao();
			Disciplina disciplina= new Disciplina();
			if(codigo != null){
				disciplina = disciplinaDao.buscar(Integer.parseInt(codigo));
				disciplinaDao.remover(disciplina);
				
				request.setAttribute("mensagem", "Disciplina " + disciplina.getNome() + " excluída com sucesso");
				request.getRequestDispatcher("cadastrarDisciplinas.jsp").forward(request, response);
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
