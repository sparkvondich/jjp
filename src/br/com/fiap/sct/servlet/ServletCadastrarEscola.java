package br.com.fiap.sct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sct.dao.EscolaDao;
import br.com.fiap.sct.entity.Escola;

@WebServlet("/admin/cadastrarEscola") 
public class ServletCadastrarEscola extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarEscola() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mensagem", "Chamada realizada pelo servlet");
		request.getRequestDispatcher("cadastrarEscolas.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String telefone = request.getParameter("telefone");
			
			Escola escola = new Escola();
			escola.setNome(nome);
			escola.setEndereco(endereco);
			escola.setTelefone(telefone);
			
			EscolaDao escolaDao = new EscolaDao();
			escolaDao.adicionar(escola);
			
			request.setAttribute("mensagem", "Escola: " + escola.getNome() + " incluída com sucesso");
			request.getRequestDispatcher("cadastrarEscolas.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.setAttribute("stacktrace", e);
			request.getRequestDispatcher("erros/exceptionPage.jsp").forward(request, response);

		}
	}
}
