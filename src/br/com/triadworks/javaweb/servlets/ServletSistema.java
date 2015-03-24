package br.com.triadworks.javaweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String nomeClasse = "br.com.triadworks.javaweb.modelo."+acao+"Logica";
		try {
			Class classe = Class.forName(nomeClasse);
			Object o = classe.newInstance();
			Logica logica = (Logica)o;
			logica.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new CaloteiroServletException(e.getMessage());
		}
		
	}

}
