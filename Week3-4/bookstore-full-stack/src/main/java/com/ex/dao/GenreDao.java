package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDao implements DAO<Genre, Integer>{
	
	/*
	 * STATEMENT - important interface in JDBC API
	 * - takes an SQL statement as a string, executes it, and 
	 * returns the result 
	 * - allow SQL injection. These are not ideal to use. Definitely 
	 * do NOT use for any SQL command that uses a parameter/variable
	 * 
	 * SQL injection - common hacking technique. it is the insertion of
	 * code as input that affects your database 
	 */

	@Override
	public List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bn_genre order by name" ;
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
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
			
			String sql = "select * from bn_genre where genre_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
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
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO BN_GENRE (NAME) VALUES(?)";
			String[] keyNames = {"Genre_Id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setString(1, obj.getName());
			
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Genre update(Genre obj) {
		return null;
	}

	@Override
	public void delete(Genre obj) {
		
	}

}
