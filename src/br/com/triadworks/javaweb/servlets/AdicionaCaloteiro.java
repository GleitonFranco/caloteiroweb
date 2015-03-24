package br.com.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.modelo.Caloteiro;

/**
 * Servlet implementation class MinhaPrimeiraServlet
 */
@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		
		Calendar dataConvertida = null;
		try {
			Date data= new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataConvertida = Calendar.getInstance();
			dataConvertida.setTimeInMillis(data.getTime());
		} catch (ParseException e) {
			System.err.println("Erro na conversão de data");
			throw new CaloteiroServletException();
		}
		
		Caloteiro c = new Caloteiro();
		c.setNome(nome);
		c.setDevendo(Integer.parseInt(devendo));
		c.setEmail(email);
		c.setDataDivida(dataConvertida);
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.adiciona(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-adicionado.jsp");
		rd.forward(request, response);
		
//		PrintWriter sysout = response.getWriter();
//		sysout.println("<html>");
//		sysout.println("<body>");
//		sysout.println(c.getNome()+" último cadastrado com sucesso!<br>");
//		sysout.println("</body>");
//		sysout.println("</html>");
	}

}
