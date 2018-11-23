package com.rev.proj1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadWelcomeViewsServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LoadWelcomeViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
		case "/ERSProj1/login.welcomeView":
			return "login";	
		case "/ERSProj1/create-account.welcomeView":
			log.trace("Clicked create account button");
			return "create-account";
		default:
			return null;
		}
			
	}
}
