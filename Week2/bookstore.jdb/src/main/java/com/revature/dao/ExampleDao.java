package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class ExampleDao {

	//Git?
	
	// TO MAKE A CALLABLE STATEMENT
	
	public static int getBooksByGenre(String genre) {
		int total = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{? = call num_books_by_genre(?) }";							// Need curly brackets for callable statements!
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, total);
			cs.setString(2, genre);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
	}

}
