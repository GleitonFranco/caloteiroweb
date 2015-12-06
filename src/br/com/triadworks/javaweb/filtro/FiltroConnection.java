package br.com.triadworks.javaweb.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.triadworks.javaweb.dao.ConnectionFactory;
@WebFilter(filterName="FiltroConnection" , urlPatterns="/*")
public class FiltroConnection implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		request.setAttribute("connection", connection);
		chain.doFilter(request, response);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Carregando.............................................");
	}

}
