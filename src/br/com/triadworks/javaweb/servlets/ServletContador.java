package br.com.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContador
 */
@WebServlet("/contador")
public class ServletContador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int contador = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contador++;
		PrintWriter saida = response.getWriter();
		saida.println("<!DOCTYPE html>");
		saida.println("<html lang=\"pt-BR\">");
		saida.println("<head>");
		saida.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		saida.println("</head>");
		saida.println("<body>");
		saida.println("Servlet de número: "+contador);
		saida.println("</body>");
		saida.println("</html>");
	}
}
