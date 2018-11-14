package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloHttpServlet extends HttpServlet {
	// HttpServlet extends GenericServlet. Here, we DO NOT have to override the service() method. We must
	// simply override AT LEAST ONE do___something method such as doGet() or doPost()
	
	private static Logger log = Logger.getLogger(HelloHttpServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp); // don't want to call the super in the get or post
		
		// USE SERVLETS TO MANIPULATE FORM DATA
		String name = req.getParameter("username");
		// req.getParameter(x); where x is input field's name OR parameter appended to URL
		String password = req.getParameter("password");	
		PrintWriter writer = resp.getWriter();
		String text = "Getting Data from form: "
				+ "\nusername- " + name
				+ "\npassword- " + password;	
		
		Enumeration<String> paramNames = req.getParameterNames();		// If we want to see all the parameters
		while(paramNames.hasMoreElements()) {
			text += "\nparam: " + paramNames.nextElement();
		}
		writer.write(text);			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String name = req.getParameter("username");
		String password = req.getParameter("password");	
		writer.write("<h1>Posting Data. Welcome, " + name + "</h1>");
		
		
	}

}
