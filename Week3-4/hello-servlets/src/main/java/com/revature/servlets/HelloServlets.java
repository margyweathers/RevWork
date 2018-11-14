package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

// The endpoint for this servlet, as denoted in web.xml is /test
// http://localhost:8082/hello-servlets/test
public class HelloServlets extends GenericServlet{
	
	static int counter = 0;

	private static Logger log = Logger.getLogger(HelloServlets.class);
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Initializing hello servlet");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		log.trace("Servicing hello servlet");
		
		String context = getServletContext().getInitParameter("AppInfo");
		String config = getServletConfig().getInitParameter("secret");
		
		// PrintWriter allows you to write responses
		PrintWriter writer = res.getWriter();	// adding data to response object, in the form of the response body
		res.setContentType("text/html");
		String text = "<h1>Hello Servlets</h1>"
				+ "<br>"
				+ "This is a response from the HelloServlet"
				+ "<br>"
				+ "<i>Request #" + ++counter + "</i>"
				+ "<br>Servlet Context: " + context
				+ "<br>Servlet Config: " + config;
		writer.write(text); 	//sends parameter as a response body
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log.trace("destroying hello servlet");
	}

}
