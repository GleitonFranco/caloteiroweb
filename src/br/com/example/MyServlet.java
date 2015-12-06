package br.com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testalistener")
public class MyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Dog dog = (Dog)(getServletContext().getAttribute("dog"));
		writer.println("A raça do cachorro global é::"+dog.getRaca());
	}

}
