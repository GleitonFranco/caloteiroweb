package br.com.triadworks.javaweb.modelo;

import java.io.IOException;
import java.sql.Connection;
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

public class CaloteiroAlteradoLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = (Connection)request.getAttribute("connection");
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		Caloteiro c = dao.getCaloteiro(Long.parseLong(request.getParameter("labelID")));
		Calendar dataConvertida = converteStringParaData(request.getParameter("dataDivida"));
		c.setNome(request.getParameter("nome"));
		c.setDevendo(Integer.parseInt(request.getParameter("devendo")));
		c.setEmail(request.getParameter("email"));
		c.setDataDivida(dataConvertida);
		dao.altera(c);
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-adicionado.jsp");
		rd.forward(request, response);
	}

	private Calendar converteStringParaData(String dataDivida) throws CaloteiroServletException {
		Calendar dataConvertida=null;
		try {
			Date data= new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataConvertida = Calendar.getInstance();
			dataConvertida.setTimeInMillis(data.getTime());
		} catch (ParseException e) {
			System.err.println("Erro na conversão de data");
			throw new CaloteiroServletException();
		}
		return dataConvertida;
	}
}
