package br.com.triadworks.javaweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.triadworks.javaweb.servlets.CaloteiroServletException;

@WebFilter(filterName="FiltroTempo" , urlPatterns="/*")
public class FiltroTempo implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		chain.doFilter(request, response);
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Requisição para: "+uri+" foi de: "+ (tempoFinal - tempoInicial)+" ms");
		System.out.println("E para: "+url);
	}

	@Override
	public void init(FilterConfig arg0) throws CaloteiroServletException {
		// TODO Auto-generated method stub

	}

}
