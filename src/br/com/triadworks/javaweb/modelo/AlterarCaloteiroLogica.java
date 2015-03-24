package br.com.triadworks.javaweb.modelo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.servlets.CaloteiroServletException;

public class AlterarCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CaloteiroDAO dao = new CaloteiroDAO();
		Caloteiro caloteiro = dao.getCaloteiro(Long.parseLong(request.getParameter("selecionado")));
		request.setAttribute("caloteiroSelect", caloteiro);
		String sdata= new SimpleDateFormat("dd/MM/yyyy").format(caloteiro.getDataDivida().getTime());
		request.setAttribute("dataSelect", sdata);
		RequestDispatcher rd = request.getRequestDispatcher("/altera-caloteiro.jsp");
		rd.forward(request, response);
	}
	
}
