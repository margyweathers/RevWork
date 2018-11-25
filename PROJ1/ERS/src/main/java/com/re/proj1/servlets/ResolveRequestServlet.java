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

@WebServlet("/approve-request")
public class ResolveRequestServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(ResolveRequestServlet.class);
	private static ReimbursementService rs = new ReimbursementService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if(user == null) {
			resp.sendRedirect("login");
		}
		
		else {
			ObjectMapper mapper = new ObjectMapper();
			String requestType = req.getRequestURI();
			log.trace(requestType);
			switch(requestType) {
			case "/ERS/approve-request":
				Reimbursement onlyId = mapper.readValue(req.getInputStream(), Reimbursement.class);
				int id = onlyId.getrId();
				log.debug("rId = " + id);
				Reimbursement r = rs.getReimbursementById(id);
				r.setrStatus(2);	// 2 = APPROVED
				r.createResolveDate();
				r.setrResolver(user.getUserId());
				rs.update(r);	
				break;
			}
		}
	}
	
	
	

}
