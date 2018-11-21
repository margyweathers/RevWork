package com.revature.assignment.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		log.trace("In doGet. Loading a view");
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
		case "/servlet-assignment/home.view":
			return "home";
		case "/servlet-assignment/view-all.view":
			return "view-all";
		case "/servlet-assignment/view-by-movie.view":
			return "view-by-movie";
			
		}
		
		return null;
		
	}

}
