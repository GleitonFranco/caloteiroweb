package br.com.triadworks.javaweb.modelo;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;

public class AutenticarUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = (Connection)request.getAttribute("connection");
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		String usuLogin = request.getParameter("login");
		String usuSenha = request.getParameter("senha");
		boolean autenticado = (usuLogin!=null && usuSenha!=null) && usuLogin.equals("gleiton") && usuSenha.equals("123"); 
		if (autenticado) {
			request.getSession().setAttribute("usuariologado", usuLogin);
			response.sendRedirect("index.html");
//			RequestDispatcher rd = request.getRequestDispatcher("/listaCaloteirosJSTL.jsp");
//			rd.forward(request, response);
		} else {
			request.setAttribute("usumsg", "Login inválido! =/");
			response.sendRedirect("login.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
		}
	}

}
