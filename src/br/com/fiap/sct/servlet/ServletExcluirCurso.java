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
import br.com.fiap.sct.dao.DisciplinaDao;
import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Curso;
import br.com.fiap.sct.entity.Disciplina;
import br.com.fiap.sct.entity.Escola;

/**
 * Servlet implementation class ServletExcluirCurso
 */
@WebServlet("/admin/excluirCurso")
public class ServletExcluirCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String codigo = (String) request.getParameter("codigo");
			CursoDao dao = new CursoDao();
			Curso curso = new Curso();
			List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
			List<Aluno> listaAluno = new ArrayList<Aluno>();
			DisciplinaDao disciplinaDao = new DisciplinaDao();
			AlunoDao alunoDao = new AlunoDao();
			if(codigo != null){
				listaDisciplina = disciplinaDao.buscarDisciplinasPorCurso(Integer.parseInt(codigo));
				listaAluno = alunoDao.buscaAlunosPorCurso(Integer.parseInt(codigo));
				curso = dao.buscar(Integer.parseInt(codigo));
					if((listaDisciplina == null || listaDisciplina.size() == 0 ) && (listaAluno == null || listaAluno.size() ==0 )){
						
						dao.remover(curso);
						request.setAttribute("mensagem", "Curso: " + curso.getNome() + " excluído com sucesso");
						request.getRequestDispatcher("cadastrarCursos.jsp").forward(request, response);
					}else{
						request.setAttribute("mensagem", "Curso: " + curso.getNome() + " não pode ser excluído");
						request.getRequestDispatcher("cadastrarCursos.jsp").forward(request, response);
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
