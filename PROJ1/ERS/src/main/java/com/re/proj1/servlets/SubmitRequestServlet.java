package com.re.proj1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.re.proj1.service.ReimbursementService;

@WebServlet("/submit-request")
public class SubmitRequestServlet extends HttpServlet{

	private static Logger log = Logger.getLogger(SubmitRequestServlet.class);
	ReimbursementService rs = new ReimbursementService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("In SubmitRequestServlet");
		
		String typeString = req.getParameter("rTypeSelect");
		log.trace(typeString);									// Fix no selection bug
		int type = Integer.parseInt(typeString);
		double amount = Integer.parseInt(req.getParameter("amount"));
		String desc = req.getParameter("description");
		
		
	}
}
