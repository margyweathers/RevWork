package com.re.proj1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.re.proj1.pojos.Reimbursement;
import com.re.proj1.pojos.User;
import com.re.proj1.service.ReimbursementService;

@WebServlet("/submit-request")
public class SubmitRequestServlet extends HttpServlet{

	private static Logger log = Logger.getLogger(SubmitRequestServlet.class);
	ReimbursementService rs = new ReimbursementService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("In SubmitRequestServlet");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int author = user.getUserId();

		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement incomplete = mapper.readValue(req.getInputStream(), Reimbursement.class);
		Reimbursement r = new Reimbursement(author, incomplete.getAmount(), incomplete.getrType(), incomplete.getrDesc());
		r = rs.submit(r);
		log.trace("created a reimbursement request: " + r);
		
		
//		String typeString = req.getParameter("rTypeSelect");
//		log.trace(typeString);									// Fix no selection bug
//		int type = Integer.parseInt(typeString);
//		double amount = Double.parseDouble(req.getParameter("amount"));
//		String desc = req.getParameter("description");
//		Reimbursement r = new Reimbursement(author, amount, type, desc);
//		r = rs.submit(r);		
//		req.getRequestDispatcher("partials/employee-request-submitted.html").forward(req,resp);
		
		
	}
}
