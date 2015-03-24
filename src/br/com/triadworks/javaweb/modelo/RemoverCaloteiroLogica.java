package br.com.triadworks.javaweb.modelo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;

public class RemoverCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.deleta(Long.parseLong(request.getParameter("selecionado")));
		RequestDispatcher rd = request.getRequestDispatcher("/sistema?acao=ListarCaloteiro");
		rd.forward(request, response);
	}

}
