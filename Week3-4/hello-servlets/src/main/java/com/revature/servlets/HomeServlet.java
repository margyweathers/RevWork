package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.revature.pojos.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(HomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check if user session is available. if so, return home view, if not redirect back home
		
		HttpSession session = req.getSession();
		logger.trace("IN HOMESERVLET. SESSION: " + session.getId());
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			//redirect to login page
			resp.sendRedirect("login");
		}
		else {
			//welcome page to user
			String text = "";
			PrintWriter writer = resp.getWriter();
			text += "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>App</title>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\"\r\n" + 
					"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\"\r\n" + 
					"	integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"\r\n" + 
					"	crossorigin=\"anonymous\">\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
					"	integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n" + 
					"	integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"<script\r\n" + 
					"	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"\r\n" + 
					"	integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\"\r\n" + 
					"	crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div class=\"jumbotron\">\r\n" + 
					"	<h1>Welcome, "+ user.getUsername() +"</h1>\r\n" + 
					"	<i>"+user.getData() +"</i>\r\n" + 
					"<form method=\"GET\" action=\"logout\">\r\n" + 
					"<input type=\"submit\" value=\"Log Out\" class=\"btn btn-primary\">\r\n" + 
					"</form>" +
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>";
			
			
			writer.write(text);
		}
		
		
	}
	
	

}