package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.pojos.Genre;
import com.ex.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet{
	
	private Logger logger = Logger.getLogger(GenreServlet.class);
	// servlets talks to service layer, which talks to the dao
	static GenreService gService = new GenreService();
	
	// Get all genres
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// consult Service layer for data
		List<Genre> genres = gService.getAll();
		// *** USE OBJECT MAPPER TO TRANSFORM JAVA OBJECT INTO JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(genres);
		
		// send response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
		
	}
	
	// Add genre
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Genre g = mapper.readValue(req.getInputStream(), Genre.class);
		g = gService.addGenre(g.getName());
		logger.trace("Added New Genre");
	}
	
}
