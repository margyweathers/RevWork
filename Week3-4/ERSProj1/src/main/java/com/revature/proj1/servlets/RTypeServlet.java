package com.revature.proj1.servlets;

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
import com.revature.proj1.pojos.RType;
import com.revature.proj1.service.RTypeService;

@WebServlet("/r-types")
public class RTypeServlet extends HttpServlet{

	private static RTypeService typeService = new RTypeService();
	private static Logger log = Logger.getLogger(RTypeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RType> types = typeService.getAll();
		log.trace("Got r-types in RType Servlet: " + types);
		ObjectMapper mapper = new ObjectMapper();
		String typesJson = mapper.writeValueAsString(types);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(typesJson);
	}
	
}
