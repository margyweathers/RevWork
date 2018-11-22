package com.revature.proj1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadEmployeeViewsServlet extends HttpServlet{
private static Logger log = Logger.getLogger(LoadEmployeeViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) + ".html";
		log.debug(resourcePath);
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.trace("In LoadEmployeeViews Servlet process()");
		switch(req.getRequestURI()) {
		case "/ERSProj1/front.employeeView":
			return "employee-front";
		case "/ERSProj1/all.employeeView":
			return "employee-all";
		case "/ERSProj1/past.employeeView":
			return "employee-past";
		case "/ERSProj1/submit.employeeView":
			return "employee-submit";
		}
	
			
			
		return null;
	}
	

}








