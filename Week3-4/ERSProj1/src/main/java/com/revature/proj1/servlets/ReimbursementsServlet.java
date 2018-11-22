package com.revature.proj1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.proj1.pojos.Reimbursement;
import com.revature.proj1.pojos.User;
import com.revature.proj1.service.ReimbursementService;


@WebServlet({"/get-pending-by-author","/get-past-by-author", "/get-past-by-author" })
public class ReimbursementsServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(ReimbursementsServlet.class);
	private static ReimbursementService rs = new ReimbursementService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		String requestType = req.getRequestURI();
		log.trace(requestType);
		switch(requestType) {
		case "/ERSProj1/get-pending-by-author":
			reimbs = rs.getPendingReimbursementsByAuthor(user.getUserId());
			break;
		case "/ERSProj1/get-past-by-author":
			reimbs = rs.getPastReimbursementsByAuthor(user.getUserId());
		case "get-all-r":
			reimbs = rs.getAllReimbursements();
			break;
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String reimsJson = mapper.writeValueAsString(reimbs);
		log.debug(reimbs);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(reimsJson);
		
	}
	

}














