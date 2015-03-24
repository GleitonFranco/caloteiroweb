package br.com.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MinhaPrimeiraServlet
 */
@WebServlet("/minhaprimeiraservlet")
public class MinhaPrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinhaPrimeiraServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter sysout = response.getWriter();
		sysout.println("<html>");
		sysout.println("<body>");
		sysout.println("Meu primeiro Servlet!<br>");
		sysout.println("Aí foi!");
		sysout.println("</body>");
		sysout.println("</html>");
	}

}
