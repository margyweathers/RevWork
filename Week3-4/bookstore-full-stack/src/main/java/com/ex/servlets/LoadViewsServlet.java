package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("Load View Request Sent To: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/bookstore-full-stack/home.view":
			return "home";
		case "/bookstore-full-stack/books.view":
			return "books";
		case "/bookstore-full-stack/author.view":
			return "author";
		case "/bookstore-full-stack/genre.view":
			return "genre";
		
		}
		return null;
	}

}
