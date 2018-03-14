package br.com.fiap.sct.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.CursoDao;
import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.entity.Curso;
import br.com.fiap.sct.entity.Escola;

/**
 * Servlet implementation class ServletExcluirEscola
 */
@WebServlet("/admin/excluirEscola")
public class ServletExcluirEscola extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirEscola() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String codigo = (String) request.getParameter("codigo");
			EscolaDao dao = new EscolaDao();
			CursoDao cursoDao = new CursoDao();
			Escola escola = new Escola();
			List<Curso> listaCursos = new ArrayList<Curso>();
			if(codigo != null){
				escola = dao.buscar(Integer.parseInt(codigo));
				listaCursos = cursoDao.buscarCursoPorEscola(Integer.parseInt(codigo));
				if(listaCursos == null || listaCursos.size() == 0){
					dao.remover(escola);
					request.setAttribute("mensagem", "Escola: " + escola.getNome() + " excluída com sucesso");
					request.getRequestDispatcher("cadastrarEscolas.jsp").forward(request, response);
				}else{
					request.setAttribute("mensagem", "Escola: " + escola.getNome() + " não pode ser excluída");
					request.getRequestDispatcher("cadastrarEscolas.jsp").forward(request, response);
				}
				
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
