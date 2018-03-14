package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.sct.dao.AlunoDao;
import br.com.fiap.sct.dao.UsuarioDao;
import br.com.fiap.sct.entity.Aluno;
import br.com.fiap.sct.entity.Usuario;
import br.com.fiap.sct.type.Perfil;

@WebServlet(urlPatterns = { "/login" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String login = request.getParameter("login").trim();
			String senha = request.getParameter("senha").trim();
			int codigoPerfil = Integer.parseInt(request.getParameter("perfil").trim());
			
			Perfil perfil = this.verificaPerfil(codigoPerfil);

			UsuarioDao dao = new UsuarioDao();
			Usuario usuarioAutenticado = dao.buscarUsuario(login, senha, perfil);
			
			if (usuarioAutenticado != null) {
				HttpSession session = request.getSession();
				session.setAttribute("usuarioAutenticado", usuarioAutenticado);
				
				if(perfil == Perfil.ALUNO){
					Aluno aluno = new AlunoDao().consultarAlunoPeloUsuario(usuarioAutenticado.getId());
					session.setAttribute("codigoAluno", aluno.getId());
				}
				response.sendRedirect("admin/home.jsp");
				
			} else {
				
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}

	}
	
	private Perfil verificaPerfil(int codigoPerfil){
		
		if(Perfil.ADMINISTRADOR.getCodigo() == codigoPerfil){
			return Perfil.ADMINISTRADOR;
		} else if(Perfil.PROFESSOR.getCodigo() == codigoPerfil) {
			return Perfil.PROFESSOR;
		} else if(Perfil.ALUNO.getCodigo() == codigoPerfil){
			return Perfil.ALUNO;
		} else {
			throw new IllegalArgumentException("Perfil inválido");
		}
		
	}

}
