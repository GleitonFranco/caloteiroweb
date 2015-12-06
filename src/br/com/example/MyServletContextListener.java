package br.com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		String raca = sc.getInitParameter("racadog");
		Dog dog = new Dog(raca);
		sc.setAttribute("dog",dog);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}


}
