package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projos.Genre;
import com.revature.util.ConnectionFactory;

public class GenreDao implements DAO<Genre, Integer> {

	/*
	 * STATEMENT - important interface in JDBC API
	 * - takes a SQL statement as a string, executes it, and returns the result
	 * - statements allow SQL injection. These are not ideal to use. Definitely do NOT use for 
	 * 		any SQL command that uses a parameter/variable
	 * 
	 * SQL injection - common hacking technique. It is the insertion of code as
	 * input that affects your database
	 * 
	 */
	
	@Override
	public List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM BN_GENRE ORDER BY NAME";
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);
			
			// returns false when there are no more rows in result set
			while(rs.next()) {
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				genres.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
	
	
	/*
	 * PREPARED STATEMENT
	 */
	@Override
	public Genre findById(Integer id) {
		Genre g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM BN_GENRE WHERE GENRE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);		// set what the '?' is supposed to be
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				g = new Genre();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}

	
	@Override
	public Genre save(Genre obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);		// setting auto-commit to false for example
			
			// going to get the auto-generated keys via a prepared statement
			String sql = "INSERT INTO BN_GENRE(NAME) VALUES(?)";
			String[] keyNames = {"Genre_Id"}; 		// values we know are going to be auto-generated
			
			/* prepareStatement() creates a default PreparedStatement object capable of returning the auto-generated keys 
			 * designated by the given array.This array contains the names of the columns in the target table 
			 * that contain the auto-generated keys that should be returned.The driver will ignore the array 
			 * if the SQL statement is not an INSERT statement
			 */
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);	// so ps can now return the auto-generated keys
			ps.setString(1, obj.getName());
			
			int numRows = ps.executeUpdate();	// executeUpdate() returns the row count for SQL Data Manipulation Language (DML) statements
			if (numRows > 0) {								// making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					obj.setId(pk.getInt(1));
				}
				conn.commit();

			}		
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Genre obj) {
		// TODO Auto-generated method stub
		
	}

}
