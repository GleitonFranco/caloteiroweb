package br.com.triadworks.javaweb.filtro;

import java.io.IOException;
import java.net.URI;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName="FiltroLogin" , urlPatterns="/*")
public class FiltroLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		String usuario = (String)httpReq.getSession().getAttribute("usuariologado");
		String uri = httpReq.getRequestURI();
		String acao = httpReq.getParameter("acao");
		acao = acao==null?"":acao;
		if (usuario!=null || uri.endsWith("png") || acao.endsWith("AutenticarUsuario") ) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(httpReq, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
