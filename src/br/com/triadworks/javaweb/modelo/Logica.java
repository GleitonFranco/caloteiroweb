package br.com.triadworks.javaweb.modelo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}