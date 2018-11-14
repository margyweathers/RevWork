package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.DummyUserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	static DummyUserService userService = new DummyUserService();
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	// Retrieve all sers as JSON String
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// testing servlet context
		String context = getServletContext().getInitParameter("AppInfo");
		log.trace("Servlet Context in UserServlet: " + context);
		
		
		List<User> users = userService.getUsers();		// get all users from "persistence"
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}
	
}
