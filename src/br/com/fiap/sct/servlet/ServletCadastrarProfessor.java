package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.dao.ProfessorDao;
import br.com.fiap.sct.dao.UsuarioDao;
import br.com.fiap.sct.entity.Escola;
import br.com.fiap.sct.entity.Professor;
import br.com.fiap.sct.entity.Usuario;
import br.com.fiap.sct.type.Perfil;

@WebServlet("/admin/cadastrarProfessor")
public class ServletCadastrarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarProfessor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("cadastrarProfessores.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			EscolaDao escolaDao = new EscolaDao();
			Escola escola = escolaDao.buscar(Integer.parseInt(request.getParameter("escolaSelecionada")));
			
			Professor professor = new Professor();
			professor.setEscola(escola);
			professor.setNome(request.getParameter("nome"));
			
			Usuario usuario = new Usuario();
			usuario.setPerfil(Perfil.PROFESSOR);
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			professor.setUsuario(usuario);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			ProfessorDao professorDao = new ProfessorDao();
			usuarioDao.adicionar(usuario);
			professorDao.adicionar(professor);
			
			request.setAttribute("mensagem", "Usuário " + usuario.getId() + " incluído com sucesso");
			
			request.getRequestDispatcher("cadastrarProfessores.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("/erros/exceptionPage.jsp").forward(request, response);
		}
	}
}
