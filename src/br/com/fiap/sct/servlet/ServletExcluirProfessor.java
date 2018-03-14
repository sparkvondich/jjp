package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.entity.Professor;

/**
 * Servlet implementation class ServletExcluirProfessor
 */
@WebServlet("/admin/excluirProfessor")
public class ServletExcluirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletExcluirProfessor() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try{
	    	String codigo = (String) request.getParameter("codigo");
	    	ProfessorDao professorDao = new ProfessorDao();
	    	Professor professor = new Professor();
	    	if(codigo != null){
	    		professor = professorDao.buscar(Integer.parseInt(codigo));
	    		professorDao.remover(professor);
	    		request.setAttribute("mensagem", "Professor " + professor.getNome() + " excluído com sucesso");
				request.getRequestDispatcher("cadastrarProfessores.jsp").forward(request, response);
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
